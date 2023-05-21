package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.CD;
import view.Livro;

/**
 *
 * @author hp
 */
public class CDModel {

   Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList <CD> cds = new ArrayList <>();
    
    public void registarCD (CD cd) throws ClassNotFoundException {
        
        
        String sql = "insert into tcd (fk_item, id, faixas, gravadora, duracao) values (?, ?, ?, ?, ?)";
        connect = new Conexao().conexaoBD();        
        
        try {
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, cd.getId());
            pstm.setInt(2, cd.getIdCD());
            pstm.setInt(3, cd.getFaixas());
            pstm.setString(4, cd.getGravadora());
            pstm.setTime(5, cd.getDuracao());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public ArrayList<CD> pesquisarCD () throws ClassNotFoundException {
        
        String sql = "select * from tcd";
        connect = new Conexao().conexaoBD(); 
        
        try {
            cds.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                String dataString = rs.getString("dataPublicacao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
                LocalDate data = LocalDate.parse(dataString, formatter);    
                Time myTime = Time.valueOf(rs.getString("duracao"));
                CD cd = new CD (rs.getInt("idCD"), rs.getString("gravadora"), rs.getInt("faixas"), myTime);
                cds.add(cd);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return cds;
    }

}




package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Livro;

/**
 *
 * @author hp
 */
public class LivroModel {    
    
    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList <Livro> livros = new ArrayList <>();
    
    public void registarLivro (Livro livro) throws ClassNotFoundException {
        
        
        String sql = "insert into tlivro (fk_item, isbn, genero, editora, numeroPaginas) values (?, ?, ?, ?, ?)";
        connect = new Conexao().conexaoBD();        
        
        try {
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, livro.getId());
            pstm.setInt(2, livro.getIsbn());
            pstm.setString(3, livro.getGenero());
            pstm.setString(4, livro.getEditora());            
            pstm.setInt(5, livro.getNumeroPaginas());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public ArrayList<Livro> pesquisarLivro () throws ClassNotFoundException {
        
        String sql = "select * from tlivro";
        connect = new Conexao().conexaoBD(); 
        
        try {
            livros.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                String dataString = rs.getString("dataPublicacao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
                LocalDate data = LocalDate.parse(dataString, formatter);                
                Livro livro = new Livro (rs.getInt("isbn"), rs.getString("editora"), rs.getString("genero"), rs.getInt("numeroPaginas"), rs.getString("titulo"), rs.getString("tipo"), data);
                livros.add(livro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return livros;
    }

}

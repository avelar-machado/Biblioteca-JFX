/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import view.Revista;

/**
 *
 * @author hp
 */
public class RevistaModel {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Revista> revistas = new ArrayList<>();

    public void registarRevista(Revista revista) throws ClassNotFoundException {

        String sql = "insert into trevista (fk_item, issn, edicao, editora, numeroPaginas) values (?, ?, ?, ?, ?)";
        connect = new Conexao().conexaoBD();

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, revista.getId());
            pstm.setInt(2, revista.getIssn());
            pstm.setInt(3, revista.getEdicao());
            pstm.setString(4, revista.getEditora());
            pstm.setInt(5, revista.getNumeroPaginas());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Revista> pesquisarLivro() throws ClassNotFoundException {

        String sql = "select * from trevista";
        connect = new Conexao().conexaoBD();

        try {
            revistas.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String dataString = rs.getString("dataPublicacao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
                LocalDate data = LocalDate.parse(dataString, formatter);
                Revista revista = new Revista(rs.getInt("issn"), rs.getString("editora"), rs.getInt("edicao"), rs.getInt("numeroPaginas"));
                revistas.add(revista);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return revistas;
    }
}

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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Autor;

/**
 *
 * @author hp
 */
public class AutorModel {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Autor> autores = new ArrayList<>();
    
    public void registarAutor(Autor autor) throws ClassNotFoundException {

        String sql = "insert into tautor (nome, apelido, endereco, qtdItem) values (?, ?, ?, ?)";
        connect = new Conexao().conexaoBD();

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getApelido());
            pstm.setString(3, autor.getEndereco());
            pstm.setInt(4, autor.getQtdItem());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Autor> pesquisarAutor() throws ClassNotFoundException {

        String sql = "select * from tautor";
        connect = new Conexao().conexaoBD();

        try {
            autores.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor(rs.getInt("code"), rs.getString("nome"), rs.getString("apelido"), rs.getString("endereco"), rs.getInt("qtdItem"));
                autores.add(autor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return autores;
    }

}

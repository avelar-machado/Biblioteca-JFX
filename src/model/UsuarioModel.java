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
import view.Usuario;

/**
 *
 * @author hp
 */
public class UsuarioModel {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public void registarUsuario(Usuario usuario) throws ClassNotFoundException {

        String sql = "insert into tusuario (numeroMatricula, nome, apelido, endereco, username, senha) values (?, ?, ?, ?, ?, ?)";
        connect = new Conexao().conexaoBD();

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, usuario.getNumeroMatricula());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, usuario.getApelido());
            pstm.setString(4, usuario.getEndereco());
            pstm.setString(5, usuario.getUsername());
            pstm.setString(6, usuario.getSenha());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    

    public ArrayList<Usuario> pesquisarUsuario() throws ClassNotFoundException {

        String sql = "select * from tusuario";
        connect = new Conexao().conexaoBD();

        try {
            usuarios.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.dadosUser(rs.getInt("numeroMatricula"), rs.getString("nome"), rs.getString("apelido"), rs.getString("endereco"), rs.getString("username"), rs.getString("senha"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return usuarios;
    }

}

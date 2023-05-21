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
import view.Emprestimo;
import view.Login;
import view.Usuario;

/**
 *
 * @author hp
 */
public class LoginModel {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    Usuario usuario = new Usuario();
    
    public void registarUsuarioUser(String username,  String senha) throws ClassNotFoundException {

        String sql = "insert into tusuariouser (username, senha) values (?, ?)";
        connect = new Conexao().conexaoBD();

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, senha);

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Usuario pesquisarUsuario(Login log) throws ClassNotFoundException {

        String sql = "select * from tusuario where username = '"+log.getUsername()+"' and senha = '"+log.getSenha()+"'";
        connect = new Conexao().conexaoBD();
        try {
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            
              while (rs.next()) {
                usuario.dadosUser(rs.getInt("numeroMatricula"), rs.getString("nome"), rs.getString("apelido"), rs.getString("endereco"), rs.getString("username"), rs.getString("senha"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return usuario;
    }
    
    public Usuario pesquisarUsuarioUser() throws ClassNotFoundException {

        String sql = "select * from tusuariouser";
        connect = new Conexao().conexaoBD();

        try {
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            
              while (rs.next()) {
                usuario.dadosUser(0, "", "", "", rs.getString("username"), rs.getString("senha"));
            }

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return usuario;
    }
    
    public boolean pesquisarUser(String username, String senha) throws ClassNotFoundException {

        String sql = "select * from tusuario where username = '"+username+"' and senha = '"+senha+"'";
        connect = new Conexao().conexaoBD();
        boolean bool = false;
        try {
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            
              while (rs.next()) {
                bool = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return bool;
    }
    
    public void deleteUser () throws ClassNotFoundException {
        
        
        connect = new Conexao().conexaoBD();
        
        try {
            String sql = "Delete from tusuariouser";
            pstm = connect.prepareStatement(sql);
            int rsAltera = pstm.executeUpdate();
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 

}

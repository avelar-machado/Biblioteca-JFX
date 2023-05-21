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
/**
 *
 * @author hp
 */
public class EmprestimoModel {
    
    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList <Emprestimo> emprestimos = new ArrayList <>();
    
    public void registarEmprestimo (Emprestimo emprestimo) throws ClassNotFoundException {
        String sql = "insert into temprestimo (fk_item, fk_usuario, descricao, dataDevolucao) values (?, ?, ?, ?)";
        connect = new Conexao().conexaoBD();        
        
        try {
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, emprestimo.getFk_item());
            pstm.setInt(2, emprestimo.getFk_usuario());
            pstm.setString(3, emprestimo.getDescricao());
            String dataString = ""+emprestimo.getDataDevolucao();
            pstm.setString(4, dataString);
            
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    public void devolverEmprestimo (Emprestimo emp ) throws ClassNotFoundException {
        
        
        connect = new Conexao().conexaoBD();
        
        try {
            String sql = "Delete from temprestimo where fk_item = " + emp.getFk_item() +" and fk_usuario = " + emp.getFk_usuario();
            pstm = connect.prepareStatement(sql);
            int rsAltera = pstm.executeUpdate();
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
    
}

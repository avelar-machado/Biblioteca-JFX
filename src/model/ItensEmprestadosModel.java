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
import view.ItensEmprestados;

/**
 *
 * @author hp
 */
public class ItensEmprestadosModel {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ItensEmprestados> emprestados = new ArrayList<>();

    public ArrayList<ItensEmprestados> pesquisarItensEmprestados() throws ClassNotFoundException {

        String sql = "select * from temprestimo, titem where id = fk_item";
        connect = new Conexao().conexaoBD();

        try {
            emprestados.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String dataString = rs.getString("dataDevolucao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(dataString, formatter);
                ItensEmprestados emp = new ItensEmprestados(rs.getInt("fk_item"), rs.getString("tipo"), rs.getString("titulo"), rs.getString("descricao"), rs.getInt("fk_usuario"), data);
                emprestados.add(emp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return emprestados;
    }
    
    
    public ArrayList<ItensEmprestados> pesquisarItensEmprestadosUsuario(int user) throws ClassNotFoundException {

        String sql = "select * from temprestimo, titem where id = fk_item and fk_usuario = '"+user+"'";
        connect = new Conexao().conexaoBD();

        try {
            emprestados.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String dataString = rs.getString("dataDevolucao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(dataString, formatter);
                ItensEmprestados emp = new ItensEmprestados(rs.getInt("fk_item"), rs.getString("tipo"), rs.getString("titulo"), rs.getString("descricao"), rs.getInt("fk_usuario"), data);
                emprestados.add(emp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return emprestados;
    }

}

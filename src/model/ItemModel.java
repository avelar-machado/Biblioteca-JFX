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
import view.Autor;
import view.Item;

/**
 *
 * @author hp
 */
public class ItemModel {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Item> itens = new ArrayList<>();

    public void registarItem(Item item) throws ClassNotFoundException {

        String sql = "insert into titem (titulo, tipo, dataPublicacao) values (?, ?, ?)";
        connect = new Conexao().conexaoBD();
        String data = "" + item.getDataPublicacao();

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, item.getTitulo());
            pstm.setString(2, item.getTipo());
            pstm.setString(3, data);

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Item> pesquisarItem() throws ClassNotFoundException, SQLException {

        String sql = "select * from titem";
        connect = new Conexao().conexaoBD();

        try {
            itens.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                String dataString = rs.getString("dataPublicacao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(dataString, formatter);
                Item item = new Item(rs.getString("titulo"), data, rs.getString("tipo"));
                item.setId(rs.getInt("id"));
                itens.add(item);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return itens;
    }

    public ArrayList<Item> pesquisarItem2(String tipo) throws ClassNotFoundException, SQLException {

        String sql = "select * from titem where tipo = '" + tipo + "'";
        connect = new Conexao().conexaoBD();

        try {
            itens.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String dataString = rs.getString("dataPublicacao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(dataString, formatter);
                Item item = new Item(rs.getString("titulo"), data, rs.getString("tipo"));
                item.setId(rs.getInt("id"));
                itens.add(item);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return itens;
    }

    public ArrayList<Item> pesquisarItemDisp() throws ClassNotFoundException, SQLException {

        String sql = "SELECT *\n"
                + "FROM titem\n"
                + "LEFT JOIN temprestimo ON titem.id = temprestimo.fk_item\n"
                + "WHERE temprestimo.fk_item IS NULL";
        connect = new Conexao().conexaoBD();

        try {
            itens.clear();
            itens.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String dataString = rs.getString("dataPublicacao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(dataString, formatter);
                Item item = new Item(rs.getString("titulo"), data, rs.getString("tipo"));
                item.setId(rs.getInt("id"));
                itens.add(item);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return itens;
    }

    public ArrayList<Item> pesquisarItemDisp2(int code) throws ClassNotFoundException, SQLException {

        String sql = "SELECT *\n"
                + "FROM titem\n"
                + "LEFT JOIN temprestimo ON titem.id = temprestimo.fk_item\n"
                + "WHERE temprestimo.fk_item IS NULL";
        connect = new Conexao().conexaoBD();

        System.out.println("Cheguei");

        try {
            itens.clear();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                if (rs.getInt("id") == code) {
                    String dataString = rs.getString("dataPublicacao");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate data = LocalDate.parse(dataString, formatter);
                    Item item = new Item(rs.getString("titulo"), data, rs.getString("tipo"));
                    item.setId(rs.getInt("id"));
                    itens.add(item);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return itens;
    }

    public void registarAutorItem(Item item, Autor autor) throws ClassNotFoundException {

        String sql = "insert into tautoritem (fk_item, fk_autor) values (?, ?)";
        connect = new Conexao().conexaoBD();

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, item.getId());
            pstm.setInt(2, autor.getCode());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}

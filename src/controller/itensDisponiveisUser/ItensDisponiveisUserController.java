/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.itensDisponiveisUser;

import controller.emprestarItem.EmprestarItemController;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.ItemModel;
import view.Item;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ItensDisponiveisUserController implements Initializable {

   
    @FXML
    private VBox emprestadosForm;

    @FXML
    private TableColumn<Item, Integer> codigo;

    @FXML
    private TableColumn<Item, String> tipo;

    @FXML
    private TableColumn<Item, String> titulo;

    @FXML
    private TableColumn<Item, Integer> data;
    
    @FXML
    private TableView<Item> tbvItens;
    
    @FXML
    private TextField item;
    ItemModel it = new ItemModel();
    

    @FXML
    private void btnItem() throws ClassNotFoundException, ParseException, SQLException {
        
        ArrayList<Item> itens = new ArrayList<>();
        
        if (!"".equals(item.getText())) {
            itens = it.pesquisarItemDisp2(Integer.parseInt(item.getText()));
        } else {
            itens = it.pesquisarItemDisp();
        }        
        
        ObservableList<Item> its = FXCollections.observableArrayList(itens);
        codigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));;
        data.setCellValueFactory(new PropertyValueFactory<>("dataPublicacao"));        
        tbvItens.setItems(its);
        
        item.setText("");
    
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarItens();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmprestarItemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItensDisponiveisUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarItens() throws ClassNotFoundException, SQLException {

        ArrayList<Item> itens = new ArrayList<>();
        itens = it.pesquisarItemDisp();        
        
        ObservableList<Item> its = FXCollections.observableArrayList(itens);
        codigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));;
        data.setCellValueFactory(new PropertyValueFactory<>("dataPublicacao"));
        
        tbvItens.setItems(its);

    }
    
}

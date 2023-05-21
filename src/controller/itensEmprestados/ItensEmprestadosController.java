/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.itensEmprestados;

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
import model.ItensEmprestadosModel;
import view.ItensEmprestados;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ItensEmprestadosController implements Initializable {

    @FXML
    private VBox emprestadosForm;

    @FXML
    private TableColumn<ItensEmprestados, Integer> codigo;

    @FXML
    private TableColumn<ItensEmprestados, String> tipo;

    @FXML
    private TableColumn<ItensEmprestados, String> titulo;

    @FXML
    private TableColumn<ItensEmprestados, Integer> usuario;

    @FXML
    private TableColumn<ItensEmprestados, Integer> data;

    @FXML
    private TableColumn<ItensEmprestados, String> descricao;

    @FXML
    private TableView<ItensEmprestados> tbvItens;

    @FXML
    private TextField user;

    @FXML
    private void btnUsuario() throws ClassNotFoundException, ParseException, SQLException {

        ItensEmprestadosModel emp = new ItensEmprestadosModel();
        ArrayList<ItensEmprestados> emprestados = new ArrayList<>();

        if (!"".equals(user.getText())) {
            emprestados = emp.pesquisarItensEmprestadosUsuario(Integer.parseInt(user.getText()));
        } else {
            emprestados = emp.pesquisarItensEmprestados();
        }

        ObservableList<ItensEmprestados> empresta = FXCollections.observableArrayList(emprestados);
        codigo.setCellValueFactory(new PropertyValueFactory<>("fk_item"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("fk_usuario"));
        data.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbvItens.setItems(empresta);
        
        user.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarItens();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmprestarItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarItens() throws ClassNotFoundException {

        ItensEmprestadosModel emp = new ItensEmprestadosModel();
        ArrayList<ItensEmprestados> emprestados = new ArrayList<>();

        emprestados = emp.pesquisarItensEmprestados();

        ObservableList<ItensEmprestados> empresta = FXCollections.observableArrayList(emprestados);
        codigo.setCellValueFactory(new PropertyValueFactory<>("fk_item"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("fk_usuario"));
        data.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        tbvItens.setItems(empresta);

    }

}

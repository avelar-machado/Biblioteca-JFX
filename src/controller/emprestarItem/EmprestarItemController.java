/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.emprestarItem;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.EmprestimoModel;
import model.ItemModel;
import model.UsuarioModel;
import view.Emprestimo;
import view.Item;
import view.Usuario;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class EmprestarItemController implements Initializable {

    @FXML
    private VBox emprestimoForm;

    @FXML
    private RadioButton livro;

    @FXML
    private ToggleGroup item;

    @FXML
    private RadioButton revista;

    @FXML
    private RadioButton cd;

    @FXML
    private ComboBox<Usuario> listaUsuario;

    @FXML
    private TextField descricaoEmprestimo;

    @FXML
    private TextField dataEmprestimo;

    @FXML
    private ComboBox<Item> listaItem;

    @FXML
    private Button gravarEmprestimo;

    private List<Item> itens = new ArrayList<>();
    private ObservableList<Item> it;

    private List<Usuario> usuarios = new ArrayList<>();
    private ObservableList<Usuario> at;

    UsuarioModel u = new UsuarioModel();
    ItemModel i = new ItemModel();
    String st = "Livro";

    @FXML
    private void itemRadio(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
        Object event = e.getSource();

        RadioButton radio = (RadioButton) item.getSelectedToggle();

        if (event.equals(livro)) {
            st = "Livro";
        } else if (event.equals(revista)) {
            st = "Revista";
        } else {
            st = "CD";
        }

        ItemModel k = new ItemModel();
        it = FXCollections.observableArrayList(k.pesquisarItem2(st));
        listaItem.setItems(it);

    }

    @FXML
    void btnEmprestimo(ActionEvent event) throws ClassNotFoundException, ParseException {

        String dataString = dataEmprestimo.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);

        Emprestimo emprestimo = new Emprestimo(listaItem.getValue().getId(), listaUsuario.getValue().getNumeroMatricula(), descricaoEmprestimo.getText(), data);
        EmprestimoModel emp = new EmprestimoModel();
        emp.registarEmprestimo(emprestimo);

        descricaoEmprestimo.setText("");
        dataEmprestimo.setText("");

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Emprestimo");

        Label label = new Label("Emprestimo Realizado com Sucesso.");
        StackPane pane = new StackPane(label);
        dialog.getDialogPane().setContent(pane);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarLivros();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmprestarItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarLivros() throws ClassNotFoundException, SQLException {

        for (Usuario us : u.pesquisarUsuario()) {
            usuarios.add(us);
        }

        at = FXCollections.observableArrayList(usuarios);
        listaUsuario.setItems(at);

        it = FXCollections.observableArrayList(i.pesquisarItem2(st));
        listaItem.setItems(it);

    }
}

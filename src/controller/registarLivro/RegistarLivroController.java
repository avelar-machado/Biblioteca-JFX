/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registarLivro;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import model.AutorModel;
import model.ItemModel;
import model.LivroModel;
import view.Autor;
import view.Item;
import view.Livro;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RegistarLivroController implements Initializable {

    @FXML
    private TextField tituloItem;

    @FXML
    private TextField generoLivro;

    @FXML
    private TextField isbnLivro;

    @FXML
    private TextField editoraLivro;

    @FXML
    private TextField numeroLivro;

    @FXML
    private TextField dataItem;

    @FXML
    private ComboBox<Autor> listaAutor;

    AutorModel a = new AutorModel();
    private List<Autor> autores = new ArrayList<>();
    private List<Autor> aux = new ArrayList<>();
    private ObservableList<Autor> at;
    private List<Autor> autors = new ArrayList<>();

    @FXML
    private void btnRegistarLivro() throws ClassNotFoundException, ParseException, SQLException {

        Dialog<ButtonType> dialog = new Dialog<>();
        
        String dataString = dataItem.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);
        Item item = new Item(tituloItem.getText(), data, "Livro");
        
        ItemModel it = new ItemModel();
        LivroModel lv = new LivroModel();
        it.registarItem(item);
        
        
        ArrayList<Item> au1 = it.pesquisarItem();
        
        Item au2 = au1.get(au1.size() - 1);

        
        Livro livro = new Livro(Integer.parseInt(isbnLivro.getText()), editoraLivro.getText(), generoLivro.getText(), Integer.parseInt(numeroLivro.getText()), au2.getTitulo(), au2.getTipo(), au2.getDataPublicacao());
        livro.setId(au2.getId());
        item.setId(au2.getId());
        lv.registarLivro(livro);
        
        tituloItem.setText("");
        generoLivro.setText("");
        isbnLivro.setText("");
        editoraLivro.setText("");
        numeroLivro.setText("");
        dataItem.setText("");

        for (Autor auto : autors) {
            it.registarAutorItem(item, auto);
        } 

        dialog.setTitle("Livro");
        
        Label label = new Label("Livro gravado com Sucesso.");
        StackPane pane = new StackPane(label);
        dialog.getDialogPane().setContent(pane);
        
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            carregarAutores();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistarLivroController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregarAutores() throws ClassNotFoundException {

        for (Autor ats : a.pesquisarAutor()) {
            autores.add(ats);
        }

        at = FXCollections.observableArrayList(autores);
        listaAutor.setItems(at);

    }

    @FXML
    private void adicionarAutor() throws ClassNotFoundException {

        if (!autors.contains(listaAutor.getValue())) {
            autors.add(listaAutor.getValue());
        }

    }

}

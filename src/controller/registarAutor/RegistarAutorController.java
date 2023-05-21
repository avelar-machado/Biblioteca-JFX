/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registarAutor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import model.AutorModel;
import view.Autor;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class RegistarAutorController implements Initializable {


    @FXML
    private TextField nomeA;

    @FXML
    private TextField apelidoA;

    @FXML
    private TextField enderecoA;

    @FXML
    private TextField qtdItemA;

    @FXML
    void btnRegistarAutor() throws ClassNotFoundException {        
        
        
        Autor autor = new Autor(0, nomeA.getText(), apelidoA.getText(), enderecoA.getText(), Integer.parseInt(qtdItemA.getText()));
        AutorModel aut = new AutorModel ();
        aut.registarAutor(autor);
        
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Autor");
        
        Label label = new Label("Dados do Autor gravados com Sucesso.");
        StackPane pane = new StackPane(label);
        dialog.getDialogPane().setContent(pane);        
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
        
        
        
        
        nomeA.setText("");
        enderecoA.setText("");
        apelidoA.setText("");
        qtdItemA.setText("");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

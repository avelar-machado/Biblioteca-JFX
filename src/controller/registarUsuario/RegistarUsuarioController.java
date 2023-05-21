/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registarUsuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.UsuarioModel;
import view.Usuario;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RegistarUsuarioController implements Initializable {

    @FXML
    private VBox usuarioForm;

    @FXML
    private TextField nomeU;

    @FXML
    private TextField apelidoU;

    @FXML
    private TextField matriculaU;

    @FXML
    private TextField enderecoU;

    @FXML
    private TextField usernameU;

    @FXML
    private TextField senhaU;

    @FXML
    private Button guardarUsuario;

    @FXML
    void btnRegistarUsuario() throws ClassNotFoundException {
        
        Usuario usuario = new Usuario();
        usuario.dadosUser(Integer.parseInt(matriculaU.getText()), nomeU.getText(), apelidoU.getText(), enderecoU.getText(), usernameU.getText(), senhaU.getText());
        UsuarioModel us = new UsuarioModel ();
        us.registarUsuario(usuario);
        
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Usuário");
        
        Label label = new Label("Dados do Usuário gravados com Sucesso.");
        StackPane pane = new StackPane(label);
        dialog.getDialogPane().setContent(pane);
        
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
        
        nomeU.setText("");
        enderecoU.setText("");
        usernameU.setText("");
        senhaU.setText("");
        apelidoU.setText("");
        matriculaU.setText("");

    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

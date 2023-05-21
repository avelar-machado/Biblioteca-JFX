/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import controller.FXMLMainController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnLivro;

    @FXML
    private Button btnRevista;

    @FXML
    private Button btnCD;

    @FXML
    private Button btnEmpresta;

    @FXML
    private Button btnRecebe;

    @FXML
    private Button btnDisp;

    @FXML
    private Button btnEmp;

    @FXML
    private Button btnUsuario;

    @FXML
    private Button btnAutor;

    @FXML
    private StackPane container;

    @FXML
    private VBox livroForm, cdForm, revistaForm, emprestimoForm, emprestadosForm, disponiveisForm, receberForm, usuarioForm, autorForm;

    @FXML
    public void actionEvent(ActionEvent event) {

        Object e = event.getSource();

        if (e.equals(btnLivro)) {
            livroForm.setVisible(true);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnRevista)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(true);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnCD)) {
            livroForm.setVisible(false);
            cdForm.setVisible(true);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnEmpresta)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(true);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnEmp)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(true);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnDisp)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(true);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnRecebe)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(true);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } else if (e.equals(btnUsuario)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(true);
            autorForm.setVisible(false);
        } else if (e.equals(btnAutor)) {
            livroForm.setVisible(false);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            livroForm = loadForm("/main/registarLivro/RegistarLivro.fxml");
            cdForm = loadForm("/main/registarCD/RegistarCD.fxml");
            revistaForm = loadForm("/main/registarRevista/RegistarRevista.fxml");
            emprestimoForm = loadForm("/main/emprestarItem/EmprestarItem.fxml");
            emprestadosForm = loadForm("/main/itensEmprestados/ItensEmprestados.fxml");
            disponiveisForm = loadForm("/main/itensDisponiveis/ItensDisponiveis.fxml");
            receberForm = loadForm("/main/receberItem/ReceberItem.fxml");
            usuarioForm = loadForm("/main/registarUsuario/RegistarUsuario.fxml");
            autorForm = loadForm("/main/registarAutor/RegistarAutor.fxml");

            container.getChildren().addAll(livroForm, revistaForm, cdForm, emprestimoForm, emprestadosForm, disponiveisForm, receberForm, usuarioForm, autorForm);
            livroForm.setVisible(true);
            cdForm.setVisible(false);
            revistaForm.setVisible(false);
            emprestimoForm.setVisible(false);
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(false);
            receberForm.setVisible(false);
            usuarioForm.setVisible(false);
            autorForm.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private VBox loadForm(String url) throws IOException {

        VBox vbox = FXMLLoader.load(getClass().getResource(url));
        return vbox;
    }

}

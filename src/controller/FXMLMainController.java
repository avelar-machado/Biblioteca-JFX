package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.LoginModel;
import view.Login;
import view.Usuario;

/**
 *
 * @author hp
 */
public class FXMLMainController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private TextField senhauser;

    @FXML
    private void loginUser(ActionEvent event) throws ClassNotFoundException, IOException {

        if (username.getText().equals("admin") && senhauser.getText().equals("admin")) {
            FXMLLoader fx = new FXMLLoader(FXMLMainController.class.getResource("/main/home/Home.fxml"));
            Scene s = new Scene(fx.load());
            Stage st = new Stage();
            st.setTitle("Home");
            st.setScene(s);
            st.show();
        } else {

            LoginModel lg = new LoginModel();
            if (lg.pesquisarUser(username.getText(), senhauser.getText())) {
                
                lg.registarUsuarioUser(username.getText(), senhauser.getText());
                Login log = new Login(username.getText(), senhauser.getText());
                FXMLLoader fx = new FXMLLoader(FXMLMainController.class.getResource("/main/telaUser/TelaUser.fxml"));
                Scene s = new Scene(fx.load());
                Stage st = new Stage();
                st.setTitle("Usuario");
                st.setScene(s);
                st.show();
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou usuário errado");
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}


package controller.telaUser;

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
public class TelaUserController implements Initializable {

    @FXML
    private Button btnDisp;

    @FXML
    private Button btnEmp;

    @FXML
    private VBox emprestadosForm, disponiveisForm;

    @FXML
    private StackPane container;

    public void actionEvent(ActionEvent event) {

        Object e = event.getSource();

        if (e.equals(btnEmp)) {
            emprestadosForm.setVisible(true);
            disponiveisForm.setVisible(false);
        } else if (e.equals(btnDisp)) {
            emprestadosForm.setVisible(false);
            disponiveisForm.setVisible(true);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            emprestadosForm = loadForm("/main/itensEmprestadosUser/ItensEmprestadosUser.fxml");
            disponiveisForm = loadForm("/main/itensDisponiveisUser/ItensDisponiveisUser.fxml");

            container.getChildren().addAll(emprestadosForm, disponiveisForm);
            emprestadosForm.setVisible(true);
            disponiveisForm.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    private VBox loadForm(String url) throws IOException {

        VBox vbox = FXMLLoader.load(getClass().getResource(url));
        return vbox;
    }

}

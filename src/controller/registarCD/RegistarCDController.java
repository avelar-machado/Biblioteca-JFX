package controller.registarCD;

import controller.registarLivro.RegistarLivroController;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
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
import javax.swing.JOptionPane;
import model.AutorModel;
import model.CDModel;
import model.ItemModel;
import view.Autor;
import view.CD;
import view.Item;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RegistarCDController implements Initializable {

    @FXML
    private TextField idCD;

    @FXML
    private TextField faixasCD;

    @FXML
    private TextField gravadoraCD;

    @FXML
    private TextField duracaoCD;

    @FXML
    private TextField tituloItem;

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
    private void btnRegistarCD() throws ClassNotFoundException, ParseException, SQLException {

        String dataString = dataItem.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);
        Item item = new Item(tituloItem.getText(), data, "CD");

        ItemModel it = new ItemModel();
        CDModel c = new CDModel();
        it.registarItem(item);

        ArrayList<Item> au1 = it.pesquisarItem();
        Item au2 = au1.get(au1.size() - 1);

        Time myTime = Time.valueOf(duracaoCD.getText());
        CD cd = new CD(Integer.parseInt(idCD.getText()), gravadoraCD.getText(), Integer.parseInt(faixasCD.getText()), myTime);
        cd.setId(au2.getId());
        item.setId(au2.getId());
        c.registarCD(cd);

        tituloItem.setText("");
        idCD.setText("");
        gravadoraCD.setText("");
        faixasCD.setText("");
        duracaoCD.setText("");
        dataItem.setText("");
        for (Autor auto : autors) {
            it.registarAutorItem(item, auto);
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("CD");
        
        Label label = new Label("Dados do CD gravados com Sucesso.");
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

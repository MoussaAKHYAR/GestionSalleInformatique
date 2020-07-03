package sn.isi.appgestionsalleinformatique.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sn.isi.appgestionsalleinformatique.dao.ISalle;
import sn.isi.appgestionsalleinformatique.dao.SalleImpl;
import sn.isi.appgestionsalleinformatique.entities.Salle;
import tools.Outils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SalleController implements Initializable {
    @FXML
    private TextField libelletxt;

    @FXML
    private TableColumn<Salle, Integer> idColumn;

    @FXML
    private TableColumn<Salle, String> libelleColumn;

    @FXML
    private TableView<Salle> tablesalle;

    private int idS;


    ISalle iSalle = new SalleImpl();
    @FXML
    void tableclick(MouseEvent event) {

        Salle s = tablesalle.getSelectionModel().getSelectedItem();
        idS = s.getId();

    }

    @FXML
    void ajouter(ActionEvent event){
        if (libelletxt.getText().equalsIgnoreCase("")){
            System.out.println("Veuillez remplir le champ");
        }else {
            try {
                Salle salle = new Salle();
                salle.setLibelle(libelletxt.getText());

                if (iSalle.addSalle(salle) == 1){
                    tools.Notification.NotifSucces("Sucess", "donnees ajoutes!!!");
                    libelletxt.setText("");
                    loadTable();
                }else
                {
                    tools.Notification.NotifError("error", "donnees  non  ajoutes!!!");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void supprimer(ActionEvent event){
        try {
            if(iSalle.delete(idS) == 1)
            {
                tools.Notification.NotifSucces("Sucess", "donnees supprimées!!!");
                loadTable();
            }else
            {
                tools.Notification.NotifError("error", "donnees  non  supprimées!!");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        loadTable();

    }
    @FXML
    void modifier(ActionEvent event) {
        try
        {
            Salle salle = new Salle();
            salle.setId(idS);
            salle.setLibelle(libelletxt.getText());

            if(iSalle.update(salle) == 1)
            {

                Outils.showConfirmationMessage("INFO","serveur mis a jour");
                loadTable();

            }else
            {
                Outils.showErrorMessage("erreur","veuillez ressayer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();

    }
    private void loadTable(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        libelleColumn.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        ObservableList<Salle> salles = FXCollections.observableArrayList();
        try {
            List<Salle> listSalles = iSalle.getAllSalle();
            for (Salle salle : listSalles ) {

                salles.add(salle);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        tablesalle.setItems(salles);

    }
}

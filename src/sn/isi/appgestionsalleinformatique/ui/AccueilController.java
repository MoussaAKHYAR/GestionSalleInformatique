package sn.isi.appgestionsalleinformatique.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import tools.Outils;

import java.io.IOException;

public class AccueilController{
    @FXML
    private Button sallebtn;
    @FXML
    private Button machinebtn;
    @FXML
    private Button adminbtn;

    @FXML
    void salle(ActionEvent event){
        String url = "/sn/isi/appgestionsalleinformatique/ui/salle.fxml";
        try {
            Outils.load(event,url,"Salle");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void machine(ActionEvent event){
        String url = "/sn/isi/appgestionsalleinformatique/ui/machine.fxml";
        try {
            Outils.load(event,url,"machine");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   @FXML
    void admin(ActionEvent event){
        String url = "/sn/isi/appgestionsalleinformatique/ui/admin.fxml";
        try {
            Outils.load(event,url,"Salle");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

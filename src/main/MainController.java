package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sn.isi.appgestionsalleinformatique.dao.IUser;
import sn.isi.appgestionsalleinformatique.dao.UserImpl;
import sn.isi.appgestionsalleinformatique.entities.User;
import tools.Outils;

import java.io.IOException;

public class MainController{
    @FXML
    private TextField emailtxt;
    @FXML
    private PasswordField passwordtxt;
    @FXML
    void connexion(ActionEvent event){
        String login = emailtxt.getText();
        String password = passwordtxt.getText();
        IUser user = new UserImpl();

        if (user.getLogin(login,password) != null){
           // System.out.println("ok");
            String url="../sn/isi/appgestionsalleinformatique/ui/accueil.fxml";
            tools.Notification.NotifSucces("BIENVENUE", "CONNEXION REUSSIE!!!");
            try {
                Outils.load(event,url,"Salle");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("erreur email ou mot de passe incorect");

    }


}

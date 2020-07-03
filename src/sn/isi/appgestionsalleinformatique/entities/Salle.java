package sn.isi.appgestionsalleinformatique.entities;

import java.io.Serializable;

public class Salle implements Serializable {
    private int id;
    private String libelle;

    public Salle() {
    }

    public Salle(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

package sn.isi.appgestionsalleinformatique.dao;

import sn.isi.appgestionsalleinformatique.entities.Salle;

import java.util.List;

public interface ISalle {
    public int addSalle(Salle salle);
    public int delete(int id);
    public int update(Salle salle);
    public List<Salle> getAllSalle();
}

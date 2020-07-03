package sn.isi.appgestionsalleinformatique.dao;



import sn.isi.appgestionsalleinformatique.entities.Salle;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalleImpl implements ISalle {
    private DB db = new DB();
    //private int ok;
    private ResultSet rs;

    @Override
    public int addSalle(Salle salle) {
        String sql = "INSERT INTO salle VALUES(null,?)";
        try {

            db.initPrepar(sql);
            /*passage de valeur*/
            db.getPstm().setString(1, salle.getLibelle());
               //execution de la requete
            db.executeMaj();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM salle where id=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1,id);
            db.executeMaj();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(Salle salle) {
        String sql = "update salle set libelle=? where id=?";
        try {

            db.initPrepar(sql);
            db.getPstm().setString(1, salle.getLibelle());
            db.executeMaj();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public List<Salle> getAllSalle() {
        String sql="select * from salle";
        List<Salle> salles = new ArrayList<Salle>();
        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            while(rs.next()){
                Salle salle = new Salle();

                salle.setId(rs.getInt(1));
                salle.setLibelle(rs.getString(2));
                salles.add(salle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salles;
    }
}

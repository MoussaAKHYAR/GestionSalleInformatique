package sn.isi.appgestionsalleinformatique.dao;

import sn.isi.appgestionsalleinformatique.entities.User;

import java.sql.ResultSet;

public class UserImpl implements IUser {

    private DB db = new DB();
    //private int ok;
    private ResultSet rs;

    @Override
    public User getLogin(String email, String password) {
        User user = null;
        String sql = "select * from user where email= ? and password= ?";
        try {
            //initialise la requete sql
            db.initPrepar(sql);
            db.getPstm().setString(1,email );
            db.getPstm().setString(2,password);
            rs =db.executeSelect();
            while(rs.next())
            {
                user= new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEtat(rs.getInt(6));
                user.setProfil(rs.getString(7));
            }
            rs.close();
            db.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}

package sn.isi.appgestionsalleinformatique.dao;

import sn.isi.appgestionsalleinformatique.entities.User;

import java.util.List;

public interface IUser {
    public User getLogin(String email, String password);
}

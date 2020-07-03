package sn.isi.appgestionsalleinformatique.dao;

import sn.isi.appgestionsalleinformatique.entities.Machine;

import java.util.List;

public interface IMachine {

    public int addMachine(Machine machine);
    public int delete(int id);
    public int update(int id);
    public List<Machine> getAllMachine();
}

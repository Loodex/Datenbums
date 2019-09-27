package dataLayer.dataAccessObjects;

import businessObjects.ITrainer;
import exceptions.NoNextTrainerFoundException;
import exceptions.NoPreviousTrainerFoundException;
import exceptions.NoTrainerFoundException;


import java.util.List;

public interface ITrainerDao {

    ITrainer create();
    void delete(ITrainer trainer) throws NoTrainerFoundException;
    ITrainer first() throws NoTrainerFoundException;
    ITrainer last() throws NoTrainerFoundException;
    ITrainer next(ITrainer trainer) throws NoNextTrainerFoundException;
    ITrainer previous(ITrainer trainer) throws NoPreviousTrainerFoundException;
    void save(ITrainer trainer);
    List<ITrainer> select();
    ITrainer select(int id) throws NoTrainerFoundException;

}

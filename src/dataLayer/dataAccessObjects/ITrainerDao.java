package Datenbums.src.dataLayer.dataAccessObjects;

import Datenbums.src.businessObjects.ITrainer;

import java.util.List;

public interface ITrainerDao {
    ITrainer create();

    void delete(ITrainer trainer);

    ITrainer first();

    ITrainer last();

    ITrainer next(ITrainer trainer);

    ITrainer previous(ITrainer trainer);

    void save(ITrainer trainer);

    List<ITrainer> select();

    ITrainer select(int id);

}

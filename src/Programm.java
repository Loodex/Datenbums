package Datenbums.src;

import Datenbums.src.businessObjects.ITrainer;
import Datenbums.src.dataLayer.businessObjects.Trainer;
import Datenbums.src.dataLayer.dataAccessObjects.xml.TrainerDaoXml;

import java.util.List;

public class Programm {
    public static void main(String[] args) {

        Trainer trainer = new Trainer();

        TrainerDaoXml trainerDaoXml = new TrainerDaoXml("file.xml");

        ITrainer select = trainerDaoXml.select(2);
        select.setName("Hans");

        trainerDaoXml.save(select);

    }
}

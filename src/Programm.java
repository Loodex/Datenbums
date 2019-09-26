package OOP.Datenbums.src;

import OOP.Datenbums.src.businessObjects.ITrainer;
import OOP.Datenbums.src.dataLayer.businessObjects.Trainer;
import OOP.Datenbums.src.dataLayer.dataAccessObjects.xml.TrainerDaoXml;

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

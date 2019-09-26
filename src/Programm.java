package OOP.Datenbums.src;

import OOP.Datenbums.src.dataLayer.businessObjects.Trainer;
import OOP.Datenbums.src.dataLayer.dataAccessObjects.xml.TrainerDaoXml;

public class Programm {
    public static void main(String[] args) {

        Trainer trainer = new Trainer();

        TrainerDaoXml trainerDaoXml = new TrainerDaoXml();
        trainerDaoXml.delete(trainer);
    }
}

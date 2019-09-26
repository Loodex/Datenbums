package OOP.Datenbums.src.dataLayer.businessObjects;

import OOP.Datenbums.src.businessObjects.ITrainer;

public class Trainer implements ITrainer {

    private int id;
    private String name;
    private int alter;
    private int erfahrung;

    public Trainer() {
    }

    public Trainer(int id, String name, int alter, int erfahrung) {
        this.id = id;
        this.name = name;
        this.alter = alter;
        this.erfahrung = erfahrung;
    }

    @Override
    public int getId() {
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getAlter() {
        return 0;
    }

    @Override
    public void setAlter(int alter) {

    }

    @Override
    public int getErfahrung() {
        return 0;
    }

    @Override
    public void setErfahrung(int erfahrung) {

    }
}

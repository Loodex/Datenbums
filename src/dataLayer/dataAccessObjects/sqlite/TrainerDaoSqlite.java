package dataLayer.dataAccessObjects.sqlite;

import businessObjects.ITrainer;
import dataLayer.dataAccessObjects.ITrainerDao;
import dataLayer.dataAccessObjects.businessObjects.Trainer;
import exceptions.NoNextTrainerFoundException;
import exceptions.NoPreviousTrainerFoundException;
import exceptions.NoTrainerFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainerDaoSqlite implements ITrainerDao {

    private static final String CLASSNAME = "org.sqlite.JDBC";
    private static final String CONNECTIONSTRING = "jdbc:sqlite:Trainer.db3";

    private Connection connection;

    public TrainerDaoSqlite() {
        initializeDatabaseDriver();
    }

    private void initializeDatabaseDriver() {
        try {
            Class.forName(CLASSNAME);
            connection = DriverManager.getConnection(CONNECTIONSTRING);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ITrainer create() {
        return new Trainer();
    }

    @Override
    public void delete(ITrainer trainer) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("DELETE FROM Trainer WHERE id = ?");
            statement.setInt(1, trainer.getId());
            int affectedRows = statement.executeUpdate();

            if(affectedRows == 0) {
                //TODO throw exception that trainer couldn't be deleted
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ITrainer getITrainerFromResultSet(ResultSet resultSet) {
        Trainer trainer = new Trainer();
        try {
            trainer.setId(resultSet.getInt(resultSet.findColumn("id")));
            trainer.setName(resultSet.getString(resultSet.findColumn("name")));
            trainer.setAlter(resultSet.getInt(resultSet.findColumn("age")));
            trainer.setErfahrung(resultSet.getInt(resultSet.findColumn("experience")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainer;
    }

    private ITrainer getPositionedTrainer(String orderBy) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM Trainer ORDER BY id ? LIMIT 1");
            statement.setString(1, orderBy);
            ResultSet resultSet = statement.executeQuery();
            return getITrainerFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ITrainer first() {
        return getPositionedTrainer("ASC");
    }

    @Override
    public ITrainer last()  {
       return getPositionedTrainer("DESC");
    }

    @Override
    public ITrainer next(ITrainer trainer) throws NoNextTrainerFoundException {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM Trainer WHERE id > ? ORDER BY id ASC LIMIT 1");
            statement.setInt(1, trainer.getId());
            ResultSet resultSet = statement.executeQuery();
            return getITrainerFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoNextTrainerFoundException("next not found");
        }
    }

    @Override
    public ITrainer previous(ITrainer trainer) throws NoPreviousTrainerFoundException {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM Trainer WHERE id < ? ORDER BY id DESC LIMIT 1");
            statement.setInt(1, trainer.getId());
            ResultSet resultSet = statement.executeQuery();
            return getITrainerFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoPreviousTrainerFoundException("previous not found");
        }
    }

    @Override
    public void save(ITrainer trainer) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Trainer(name, age, experience) VALUES (?, ?, ?)");
            statement.setString(1, trainer.getName());
            statement.setInt(2, trainer.getAlter());
            statement.setInt(3, trainer.getErfahrung());

            int affectedRows = statement.executeUpdate();

            if(affectedRows == 0) {
                return; //TODO throw exception trainer were not created
            }

            if(!(trainer instanceof Trainer)) {
                return; //TODO throw exception
            }

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    ((Trainer) trainer).setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ITrainer> select() {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM Trainer");
            ResultSet resultSet = statement.executeQuery();
            List<ITrainer> trainers = new ArrayList<>();
            while(resultSet.next()) {
                ITrainer trainer = getITrainerFromResultSet(resultSet);
                trainers.add(trainer);
            }
            return trainers;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public ITrainer select(int id) throws NoTrainerFoundException {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM Trainer WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.isClosed()) {
               throw new NoTrainerFoundException("no trainer found");
            }

            resultSet.next();
            return getITrainerFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoTrainerFoundException("no trainer found");
        }
    }
}

package dataLayer.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class SettingsManager {
    static private SettingsManager instance;

    private PersistenceSettings persistenceSettings;

    private SettingsManager() {
    }

    public static SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
            instance.persistenceSettings =
                    instance.readPersistenceSettings();
        }
        return instance;
    }

    public PersistenceSettings getPersistenceSettings() {
        return persistenceSettings;
    }

    private PersistenceSettings readPersistenceSettings() {
        PersistenceSettings settings = new PersistenceSettings();
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            settings.setPersistenceType(prop.getProperty("type"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return settings;
    }
}

package OOP.Datenbums.src.dataLayer.dataAccessObjects.xml;

import OOP.Datenbums.src.businessObjects.ITrainer;
import OOP.Datenbums.src.dataLayer.businessObjects.Trainer;
import OOP.Datenbums.src.dataLayer.dataAccessObjects.ITrainerDao;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrainerDaoXml implements ITrainerDao {

    private Document doc;

    public TrainerDaoXml() {
        this.doc = xmlParser("file.xml");
    }

    private Document xmlParser(String filename) {
        try {
            File file = new File(filename);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(new FileInputStream(file));

            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("file.xml").toURI());

            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            System.out.println(data);
            lines.close();

            return document;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hier lief was schief");

            //throw new NullPointerException("document = null");
        }
        return null;
    }

    @Override
    public ITrainer create() {
        Trainer trainer = new Trainer();
        return trainer;
    }

    @Override
    public void delete(ITrainer trainer) {
        int trainerId = trainer.getId();

        System.out.println(doc.getElementById("Trainer").getAttribute("Alter"));
    }

    @Override
    public ITrainer first() {
        return null;
    }

    @Override
    public ITrainer last() {
        return null;
    }

    @Override
    public ITrainer next(ITrainer trainer) {
        return null;
    }

    @Override
    public ITrainer previous(ITrainer trainer) {
        return null;
    }

    @Override
    public void save(ITrainer trainer) {

    }

    @Override
    public List<ITrainer> select() {
        return null;
    }

    @Override
    public ITrainer select(int id) {
        return null;
    }
}

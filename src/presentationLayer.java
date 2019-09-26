import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class presentationLayer extends javax.swing.JFrame {
    private JPanel contentPanel;

    public presentationLayer() {
        contentPanel = new JPanel();
        JButton neuerTrainerButton = new JButton();
        JButton trainerLöschenButton = new JButton();
        JButton datenÄndernButton = new JButton();
        JButton trainerSuchenButton = new JButton();
        JButton a1TrainerAnzeigenButton = new JButton();
        JButton letzterTrainerAnzeigenButton = new JButton();
        JMenuBar menu = new JMenuBar();
        setBounds(100,100,200,200);
        setTitle("Trainer-Verwaltung");
        setContentPane(contentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel.add(menu);
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    public static void main(String[] args) {
        presentationLayer dialog = new presentationLayer();
        dialog.pack();
        dialog.setVisible(true);


    }
}

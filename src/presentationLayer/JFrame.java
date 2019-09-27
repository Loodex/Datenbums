package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtTrainerbersicht;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame() {
		setTitle("Trainerverwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 571);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNeuerTrainer = new JMenu("Men\u00FC");
		menuBar.add(mntmNeuerTrainer);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Daten \u00E4ndern");
		mntmNeuerTrainer.add(mntmNewMenuItem);
		
		JMenuItem mntmTrainerLschen = new JMenuItem("Trainer l\u00F6schen");
		mntmNeuerTrainer.add(mntmTrainerLschen);
		
		JMenuItem mntmDatenSuchen = new JMenuItem("Daten suchen");
		mntmNeuerTrainer.add(mntmDatenSuchen);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton firstTrainer = new JButton("erster Trainer");
		firstTrainer.setBounds(12, 449, 145, 40);
		contentPane.add(firstTrainer);
		
		JButton nextTrainer = new JButton("nächster Trainer");
		nextTrainer.setBounds(451, 449, 145, 40);
		contentPane.add(nextTrainer);
		
		JButton previousTrainer = new JButton("vorheriger Trainer");
		previousTrainer.setBounds(225, 449, 145, 40);
		contentPane.add(previousTrainer);
		
		JButton lastTrainer = new JButton("letzter Trainer");
		lastTrainer.setBounds(681, 449, 145, 40);
		contentPane.add(lastTrainer);
		
		txtTrainerbersicht = new JTextField();
		txtTrainerbersicht.setText("Trainer\u00FCbersicht");
		txtTrainerbersicht.setBounds(12, 12, 145, 34);
		contentPane.add(txtTrainerbersicht);
		txtTrainerbersicht.setColumns(10);
		
		table = new JTable();
		table.setBounds(25, 408, 770, -340);
		contentPane.add(table);
		
		firstTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTrainerbersicht.isVisible()) {
					txtTrainerbersicht.setVisible(true);
					firstTrainer.setBounds(346, 106, 145, 40);
					nextTrainer.setBounds(681, 289, 145, 40);
					previousTrainer.setBounds(12, 295, 145, 40);
					lastTrainer.setBounds(346, 472, 145, 40);
				}
			}
		});
		
		nextTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		previousTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lastTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}

package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton newDataSet = new JButton("Neuer Trainer");
		newDataSet.setBounds(12, 26, 145, 40);
		contentPane.add(newDataSet);
		
		JButton deleteDataSet = new JButton("Trainer löschen");
		deleteDataSet.setBounds(241, 26, 145, 40);
		contentPane.add(deleteDataSet);
		
		JButton changeDataSet = new JButton("Daten ändern");
		changeDataSet.setBounds(464, 26, 145, 40);
		contentPane.add(changeDataSet);
		
		JButton surchDataSet = new JButton("Daten suchen");
		surchDataSet.setBounds(681, 26, 145, 40);
		contentPane.add(surchDataSet);
		
		JButton firstTrainer = new JButton("erster Trainer");
		firstTrainer.setBounds(346, 136, 145, 40);
		contentPane.add(firstTrainer);
		
		JButton nextTrainer = new JButton("nächster Trainer");
		nextTrainer.setBounds(346, 300, 145, 40);
		contentPane.add(nextTrainer);
		
		JButton previousTrainer = new JButton("vorheriger Trainer");
		previousTrainer.setBounds(346, 213, 145, 40);
		contentPane.add(previousTrainer);
		
		JButton lastTrainer = new JButton("letzter Trainer");
		lastTrainer.setBounds(346, 390, 145, 40);
		contentPane.add(lastTrainer);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(169, 158, 500, 302);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		newDataSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		deleteDataSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newDataSet.isVisible()) {
					changeDataSet.setVisible(false);
					return;
				}
				newDataSet.setVisible(true);
			}
		});
		
		changeDataSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		surchDataSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		firstTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.isVisible()) {
					textField.setVisible(true);
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

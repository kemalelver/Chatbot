package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ElektronikGirme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElektronikGirme frame = new ElektronikGirme();
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
	public ElektronikGirme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Cep Telefonu Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CepTelefonuEkleme form1 = new CepTelefonuEkleme();
				setVisible(false);
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);
		
		JLabel lblEkleyeceinizElektronikCihaz = new JLabel("Ekleyece\u011Finiz Elektronik Cihaz\u0131 Se\u00E7iniz");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEkleyeceinizElektronikCihaz, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEkleyeceinizElektronikCihaz, -122, SpringLayout.EAST, contentPane);
		contentPane.add(lblEkleyeceinizElektronikCihaz);
		
		JButton btnYazcEkle = new JButton("Yaz\u0131c\u0131 Ekle");
		btnYazcEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YazýcýGirme form1 = new YazýcýGirme();
				setVisible(false);
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnYazcEkle, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnYazcEkle, 32, SpringLayout.EAST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnYazcEkle, 138, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnYazcEkle);
	}
}

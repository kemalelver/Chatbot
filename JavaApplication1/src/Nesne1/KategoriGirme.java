package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KategoriGirme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KategoriGirme frame = new KategoriGirme();
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
	public KategoriGirme() {
		setBounds(100, 100, 569, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblrnGirmekIstediiniz = new JLabel("\u00DCr\u00FCn girmek istedi\u011Finiz Kategoriyi se\u00E7iniz");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblrnGirmekIstediiniz, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblrnGirmekIstediiniz, -161, SpringLayout.EAST, contentPane);
		lblrnGirmekIstediiniz.setVerticalAlignment(SwingConstants.TOP);
		lblrnGirmekIstediiniz.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblrnGirmekIstediiniz);
		
		JButton btnElektronik = new JButton("Elektronik");
		btnElektronik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ElektronikGirme form1 = new ElektronikGirme();
		        setVisible(false);
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnElektronik, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnElektronik, 54, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnElektronik, -252, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnElektronik, -391, SpringLayout.EAST, contentPane);
		contentPane.add(btnElektronik);
		
		JButton btnBeyazEya = new JButton("Beyaz E\u015Fya");
		btnBeyazEya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeyazEþyaGirme form1 = new BeyazEþyaGirme();
		        setVisible(false);
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBeyazEya, -3, SpringLayout.NORTH, btnElektronik);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBeyazEya, 48, SpringLayout.EAST, btnElektronik);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBeyazEya, -250, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBeyazEya, -245, SpringLayout.EAST, contentPane);
		contentPane.add(btnBeyazEya);
		
		JButton btnNewButton = new JButton("K\u0131rtasiye");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KýrtasiyeGirme form1 = new KýrtasiyeGirme();
		        setVisible(false);
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnElektronik);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 47, SpringLayout.EAST, btnBeyazEya);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, btnElektronik);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -87, SpringLayout.EAST, contentPane);
	
		contentPane.add(btnNewButton);
	}
}

package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BeyazE�yaGirme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeyazE�yaGirme frame = new BeyazE�yaGirme();
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
	public BeyazE�yaGirme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGireceinizBeyazEyay = new JLabel("Girece\u011Finiz beyaz e\u015Fyay\u0131 se\u00E7iniz");
		lblGireceinizBeyazEyay.setBounds(129, 11, 187, 14);
		contentPane.add(lblGireceinizBeyazEyay);
		
		JButton btnBuzdolab = new JButton("Buzdolab\u0131");
		btnBuzdolab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buzdolab�Girme form1 = new Buzdolab�Girme();
				setVisible(false);
				form1.setVisible(true);
			}
		});
		btnBuzdolab.setBounds(10, 41, 89, 23);
		contentPane.add(btnBuzdolab);
	}
}

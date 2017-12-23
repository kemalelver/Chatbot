package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KýrtasiyeGirme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KýrtasiyeGirme frame = new KýrtasiyeGirme();
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
	public KýrtasiyeGirme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVersatilKalem = new JButton("Versatil Kalem");
		btnVersatilKalem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KalemGirme form1 = new KalemGirme();
		        setVisible(false);
				form1.setVisible(true);
			}
		});
		btnVersatilKalem.setBounds(10, 45, 125, 40);
		contentPane.add(btnVersatilKalem);
		
		JLabel lblGirmekIstediinizKrtasiye = new JLabel("Girmek istedi\u011Finiz k\u0131rtasiye \u00FCr\u00FCn\u00FCn\u00FC se\u00E7iniz");
		lblGirmekIstediinizKrtasiye.setBounds(114, 11, 212, 24);
		contentPane.add(lblGirmekIstediinizKrtasiye);
	}
}

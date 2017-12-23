package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import Nesne1.FabrikaDeseni.Buzdolab�Olu�tur;
import Nesne1.FabrikaDeseni.�r�nOlu�turucu;
import Nesne1.FabrikaDeseni.�r�nSe�ici;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buzdolab�Girme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buzdolab�Girme frame = new Buzdolab�Girme();
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
	public Buzdolab�Girme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuzdolabnnzellikleriniGiriniz = new JLabel("Buzdolab\u0131n\u0131n \u00F6zelliklerini giriniz");
		lblBuzdolabnnzellikleriniGiriniz.setBounds(129, 11, 186, 14);
		contentPane.add(lblBuzdolabnnzellikleriniGiriniz);
		
		JLabel lblMarkas = new JLabel("Markas\u0131");
		lblMarkas.setBounds(10, 38, 46, 14);
		contentPane.add(lblMarkas);
		
		textField = new JTextField();
		textField.setBounds(212, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModeli = new JLabel("Modeli");
		lblModeli.setBounds(10, 66, 46, 14);
		contentPane.add(lblModeli);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 63, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0130\u00E7 Hacim Litresi");
		lblNewLabel.setBounds(10, 97, 111, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(212, 94, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblVerimlilikSnf = new JLabel("Verimlilik S\u0131n\u0131f\u0131");
		lblVerimlilikSnf.setBounds(10, 126, 136, 14);
		contentPane.add(lblVerimlilikSnf);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 123, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFiyat = new JLabel("Fiyat\u0131");
		lblFiyat.setBounds(10, 149, 46, 14);
		contentPane.add(lblFiyat);
		
		textField_4 = new JTextField();
		textField_4.setBounds(212, 154, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				MongoCollection<Document> buzdolab�=AnaMenu.database.getCollection("Buzdolab�");
				
				
				
		/*	Buzdolab� yeniBuzdolab� = new Buzdolab�(AnaMenu.toplam�r�nSay�s�,textField.getText(),textField_1.getText(),
					Double.parseDouble(textField_4.getText()),
					"Beyaz E�ya",Integer.parseInt(textField_2.getText()),textField_3.getText());*/
				�r�nSe�ici se� = new �r�nSe�ici();
				�r�nOlu�turucu olu�turucu = se�.�r�nSe�("Buzdolab�");
				Buzdolab� yeniBuzdolab�=(Buzdolab�)olu�turucu.�r�n�Olu�tur(AnaMenu.toplam�r�nSay�s�, textField.getText(), textField_1.getText(),Double.parseDouble(textField_4.getText()));
				Buzdolab�Olu�tur.�r�n�De�i�tir(yeniBuzdolab�, "Beyaz E�ya", Integer.parseInt(textField_2.getText()), textField_3.getText());
			boolean var=false;

			Buzdolab� kay�tl�;
			for(int i=0;i<AnaMenu.buzdolab�Listesi.size();i++)
			{
				
				kay�tl�=AnaMenu.buzdolab�Listesi.get(i);
			   if(kay�tl�.getpBrand().equals(yeniBuzdolab�.getpBrand())&& kay�tl�.getpModel().equals(yeniBuzdolab�.getpModel())
					 && kay�tl�.getpPrice()==yeniBuzdolab�.getpPrice())
			   {
				JOptionPane.showMessageDialog(null,"Ayn� buzdolab� var!");
				var=true;
			   }
			 ///  System.out.println(yeniBuzdolab�);
			}
			if(!var)
			{
				AnaMenu.toplam�r�nSay�s�++;
				AnaMenu.buzdolab�Listesi.add(yeniBuzdolab�);
				Document aaa = new Document( "pid", AnaMenu.toplam�r�nSay�s�)
						.append("Markasi",textField.getText())
						.append("Modeli", textField_1.getText())
						.append("Fiyati", textField_4.getText())
						.append("Kategorisi", "Beyaz E�ya")
						.append("�� Hacim Litresi",Integer.parseInt(textField_2.getText()))
						.append("Verimlilik S�n�f�",textField_3.getText());
		      buzdolab�.insertOne(aaa);
		      JOptionPane.showMessageDialog(null,"Buzdolab� eklendi!");
			}
			}
			
			
		});
		btnEkle.setBounds(152, 208, 89, 23);
		contentPane.add(btnEkle);
	}
}

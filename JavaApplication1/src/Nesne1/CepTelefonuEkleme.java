package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import Nesne1.FabrikaDeseni.ÜrünOluþturucu;
import Nesne1.FabrikaDeseni.ÜrünSeçici;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CepTelefonuEkleme extends JFrame {

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
					CepTelefonuEkleme frame = new CepTelefonuEkleme();
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
	public CepTelefonuEkleme() {
		setBounds(100, 100, 560, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblMarkas = new JLabel("Markas\u0131");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMarkas, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMarkas, 71, SpringLayout.WEST, contentPane);
		contentPane.add(lblMarkas);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 29, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 50, SpringLayout.EAST, lblMarkas);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -297, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModeli = new JLabel("Modeli");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblModeli, 72, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMarkas, -20, SpringLayout.NORTH, lblModeli);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMarkas, 0, SpringLayout.WEST, lblModeli);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblModeli, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblModeli);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblModeli);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 111, SpringLayout.WEST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kamera MegaPiksel");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 21, SpringLayout.SOUTH, lblModeli);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -291, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 101, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, -297, SpringLayout.EAST, contentPane);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ram Boyutu(GB)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 29, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MongoCollection<Document> cepTelefonu =AnaMenu.database.getCollection("CepTelefonu");
				
				
				
			//CellPhone yeniTelefon = new CellPhone(AnaMenu.toplamÜrünSayýsý,textField.getText(),textField_1.getText(),
			//		Double.parseDouble(textField_4.getText()),
			//		"Elektronik",Integer.parseInt(textField_2.getText()),textField_3.getText());
			
			ÜrünSeçici seç = new ÜrünSeçici();
			ÜrünOluþturucu oluþturucu = seç.ürünSeç("Telefon");
			CellPhone yeniTelefon =(CellPhone) oluþturucu.ürünüOluþtur();
			yeniTelefon.setCameraSize(Integer.parseInt(textField_2.getText()));
			yeniTelefon.setCategoryName("Elektronik");
			yeniTelefon.setpBrand(textField.getText());
			yeniTelefon.setpId(AnaMenu.toplamÜrünSayýsý);
			yeniTelefon.setpModel(textField_1.getText());
			yeniTelefon.setpPrice(Double.parseDouble(textField_4.getText()));
			yeniTelefon.setRamSize(textField_3.getText());
			
			
			boolean var=false;

			CellPhone kayýtlý;
			for(int i=0;i<AnaMenu.cepTelefonuListesi.size();i++)
			{
				
				kayýtlý=AnaMenu.cepTelefonuListesi.get(i);
			   if(kayýtlý.getpBrand().equals(yeniTelefon.getpBrand())&& kayýtlý.getpModel().equals(yeniTelefon.getpModel())
					 && kayýtlý.getpPrice()==yeniTelefon.getpPrice())
			   {
				JOptionPane.showMessageDialog(null,"Ayný telefon var!");
				var=true;
			   }
			   ///System.out.println(yeniTelefon);
			}
			if(!var)
			{
				AnaMenu.toplamÜrünSayýsý++;
				
				AnaMenu.cepTelefonuListesi.add(yeniTelefon);
				Document aaa = new Document( "pid", AnaMenu.toplamÜrünSayýsý)
						.append("Markasi",textField.getText())
						.append("Modeli", textField_1.getText())
						.append("Fiyati", textField_4.getText())
						.append("Kategorisi", "Elektronik")
						.append("MegaPikseli",Integer.parseInt(textField_2.getText()))
						.append("Rami",textField_3.getText());
		      cepTelefonu.insertOne(aaa);
		      JOptionPane.showMessageDialog(null,"Telefon Eklendi!");
			}
			
				
				////cepTelefonu.insert
				
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -114, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -241, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JLabel lblFiyat = new JLabel("Fiyat\u0131");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFiyat, 31, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFiyat, 0, SpringLayout.WEST, lblMarkas);
		contentPane.add(lblFiyat);
		
		textField_4 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, -5, SpringLayout.NORTH, lblFiyat);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_4, 85, SpringLayout.EAST, lblFiyat);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_4, -60, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCepTelefonuEkleme = new JLabel("Cep Telefonu Ekleme");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCepTelefonuEkleme, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCepTelefonuEkleme, 217, SpringLayout.WEST, contentPane);
		contentPane.add(lblCepTelefonuEkleme);
	}
}

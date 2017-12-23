package Nesne1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YazýcýGirme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YazýcýGirme frame = new YazýcýGirme();
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
	public YazýcýGirme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYazcnnzellikleriniGiriniz = new JLabel("Yaz\u0131c\u0131n\u0131n \u00F6zelliklerini giriniz");
		lblYazcnnzellikleriniGiriniz.setBounds(150, 11, 164, 14);
		contentPane.add(lblYazcnnzellikleriniGiriniz);
		
		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setBounds(10, 42, 46, 14);
		contentPane.add(lblMarka);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(10, 78, 46, 14);
		contentPane.add(lblModel);
		
		textField = new JTextField();
		textField.setBounds(212, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 72, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u00C7ift tarafl\u0131 yazd\u0131r\u0131yorsa 1, yoksa 0");
		lblNewLabel.setBounds(10, 106, 199, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(212, 103, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDakikadakiSayfaSays = new JLabel("Dakikadaki sayfa say\u0131s\u0131");
		lblDakikadakiSayfaSays.setBounds(10, 131, 164, 14);
		contentPane.add(lblDakikadakiSayfaSays);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 128, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFotokopiekebiliyorsa = new JLabel("Fotokopi \u00E7ekebiliyorsa 1, yoksa 0");
		lblFotokopiekebiliyorsa.setBounds(10, 156, 239, 14);
		contentPane.add(lblFotokopiekebiliyorsa);
		
		textField_4 = new JTextField();
		textField_4.setBounds(212, 153, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				MongoCollection<Document> yazýcý =AnaMenu.database.getCollection("Yazýcý");
				
				
				
			Yazýcý yeniYazýcý = new Yazýcý(AnaMenu.toplamÜrünSayýsý,textField.getText(),textField_1.getText(),
					Double.parseDouble(textField_5.getText()),
					"Kýrtasiye",Integer.parseInt(textField_2.getText())==1,Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText())==1);
			boolean var=false;

			Yazýcý kayýtlý;
			for(int i=0;i<AnaMenu.yazýcýListesi.size();i++)
			{
				
				kayýtlý=AnaMenu.yazýcýListesi.get(i);
			   if(kayýtlý.getpBrand().equals(yeniYazýcý.getpBrand())&& kayýtlý.getpModel().equals(yeniYazýcý.getpModel())
					 && kayýtlý.getpPrice()==yeniYazýcý.getpPrice())
			   {
				JOptionPane.showMessageDialog(null,"Ayný yazýcý var!");
				var=true;
			   }
			 
			}
			if(!var)
			{
				AnaMenu.toplamÜrünSayýsý++;
				AnaMenu.yazýcýListesi.add(yeniYazýcý);
				Document aaa = new Document( "pid", AnaMenu.toplamÜrünSayýsý)
						.append("Markasi",textField.getText())
						.append("Modeli", textField_1.getText())
						.append("Fiyati", textField_5.getText())
						.append("Kategorisi", "Elektronik")
						.append("Çift Taraflý Yazdýrma", Integer.parseInt(textField_2.getText())==1)
						.append("Dakikadaki  Sayfa Sayýsý",Integer.parseInt(textField_3.getText()))
						.append("Fotokopi çekmek",Integer.parseInt(textField_4.getText())==1);
		      yazýcý.insertOne(aaa);
		      JOptionPane.showMessageDialog(null,"Yazýcý eklendi!");
			}
			}
		});
		btnEkle.setBounds(160, 203, 89, 23);
		contentPane.add(btnEkle);
		
		JLabel lblFiyat = new JLabel("Fiyat\u0131");
		lblFiyat.setBounds(10, 181, 46, 14);
		contentPane.add(lblFiyat);
		
		textField_5 = new JTextField();
		textField_5.setBounds(212, 181, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}

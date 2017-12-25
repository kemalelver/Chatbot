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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KalemGirme extends JFrame {

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
					KalemGirme frame = new KalemGirme();
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
	public KalemGirme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKaleminzellikleriniGiriniz = new JLabel("Kalemin \u00F6zelliklerini giriniz");
		lblKaleminzellikleriniGiriniz.setBounds(135, 11, 220, 22);
		contentPane.add(lblKaleminzellikleriniGiriniz);
		
		JLabel lblMarkas = new JLabel("Markas\u0131");
		lblMarkas.setBounds(10, 41, 54, 22);
		contentPane.add(lblMarkas);
		
		textField = new JTextField();
		textField.setBounds(269, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModeli = new JLabel("Modeli");
		lblModeli.setBounds(10, 74, 46, 14);
		contentPane.add(lblModeli);
		
		textField_1 = new JTextField();
		textField_1.setBounds(269, 71, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKalemUcuIeri = new JLabel("Kalem ucu i\u00E7eri giriyorsa 1, girmiyorsa 0");
		lblKalemUcuIeri.setBounds(10, 99, 267, 22);
		contentPane.add(lblKalemUcuIeri);
		
		textField_2 = new JTextField();
		textField_2.setBounds(269, 102, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(269, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblKalemUcuap = new JLabel("Kalem ucu \u00E7ap\u0131(0.5,0.7 vs)");
		lblKalemUcuap.setBounds(10, 136, 167, 17);
		contentPane.add(lblKalemUcuap);
		
		JLabel lblFiyat = new JLabel("Fiyat\u0131");
		lblFiyat.setBounds(10, 164, 46, 14);
		contentPane.add(lblFiyat);
		
		textField_4 = new JTextField();
		textField_4.setBounds(269, 163, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MongoCollection<Document> versatilKalem =AnaMenu.database.getCollection("VersatilKalem");
				
				
				
			///VersatilKalem yeniVersatilKalem = new VersatilKalem(AnaMenu.toplamÜrünSayýsý,textField.getText(),textField_1.getText(),
				////	Double.parseDouble(textField_4.getText()),
				///	"Kýrtasiye",Double.parseDouble(textField_3.getText()),Integer.parseInt(textField_2.getText())==1);
			boolean var=false;
			ÜrünSeçici seç = new ÜrünSeçici();
			ÜrünOluþturucu oluþturucu = seç.ürünSeç("Kalem");
			VersatilKalem yeniVersatilKalem =(VersatilKalem)oluþturucu.ürünüOluþtur();
			yeniVersatilKalem.setCategoryName("Kýrtasiye");
			yeniVersatilKalem.setKalemUcu(Double.parseDouble(textField_3.getText()));
			yeniVersatilKalem.setpBrand(textField.getText());
			yeniVersatilKalem.setpId(AnaMenu.toplamÜrünSayýsý);
			yeniVersatilKalem.setpModel(textField_1.getText());
			yeniVersatilKalem.setpPrice(Double.parseDouble(textField_4.getText()));
			yeniVersatilKalem.setUcuIcýneGider(Integer.parseInt(textField_2.getText())==1);
			
			VersatilKalem kayýtlý;
			for(int i=0;i<AnaMenu.versatilKalemListesi.size();i++)
			{
				
				kayýtlý=AnaMenu.versatilKalemListesi.get(i);
			   if(kayýtlý.getpBrand().equals(yeniVersatilKalem.getpBrand())&& kayýtlý.getpModel().equals(yeniVersatilKalem.getpModel())
					 && kayýtlý.getpPrice()==yeniVersatilKalem.getpPrice())
			   {
				JOptionPane.showMessageDialog(null,"Ayný versatil kalem var!");
				var=true;
			   }
			  /// System.out.println(yeniVersatilKalem);
			}
			if(!var)
			{
				AnaMenu.toplamÜrünSayýsý++;
				AnaMenu.versatilKalemListesi.add(yeniVersatilKalem);
				Document aaa = new Document( "pid", AnaMenu.toplamÜrünSayýsý)
						.append("Markasi",textField.getText())
						.append("Modeli", textField_1.getText())
						.append("Fiyati", textField_4.getText())
						.append("Kategorisi", "Kýrtasiye")
						.append("Kalem ucu çapý:",Double.parseDouble(textField_3.getText()))
						.append("Ucu içine giriyor mu:",Integer.parseInt(textField_2.getText())==1);
		      versatilKalem.insertOne(aaa);
		      JOptionPane.showMessageDialog(null,"VersatilKalem eklendi!");
			}
			}
		});
		btnEkle.setBounds(167, 200, 89, 23);
		contentPane.add(btnEkle);
	}
}

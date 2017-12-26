package Nesne1;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import Nesne1.FabrikaDeseni.ÜrünOluþturucu;
import Nesne1.FabrikaDeseni.ÜrünSeçici;
import Strategy.EnYuksegiAl;
import Strategy.Hesaplayan;
import Strategy.OrtalamaIleHesapla;
import redis.clients.jedis.Jedis;

import javax.swing.JButton;

import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AnaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static List<CellPhone> cepTelefonuListesi= new ArrayList<CellPhone>();
	public static List<CellPhone> cepTelefonuListesi2= new ArrayList<CellPhone>();
	public static List<VersatilKalem> versatilKalemListesi = new ArrayList<VersatilKalem>();
	public static List<VersatilKalem> versatilKalemListesi2 = new ArrayList<VersatilKalem>();
	public static List<Yazýcý> yazýcýListesi = new ArrayList<Yazýcý>();
	public static List<Yazýcý> yazýcýListesi2 = new ArrayList<Yazýcý>();
	public static List<Buzdolabý> buzdolabýListesi = new ArrayList<Buzdolabý>();
	public static List<Buzdolabý> buzdolabýListesi2 = new ArrayList<Buzdolabý>();
	public static int toplamÜrünSayýsý =0;
	
	
	///MongoDB Atlas'a baðlanýyor
	public static MongoClientURI uri = new MongoClientURI(
			"mongodb://kemalelver:12345asd@cluster0-shard-00-00-gha3j.mongodb.net:27017,"
			+ "cluster0-shard-00-01-gha3j.mongodb.net:27017,cluster0-shard-00-02-gha3j.mongodb."
			+ "net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
	
	public static MongoClient mongoClient = new MongoClient(uri);
	public static MongoDatabase database = mongoClient.getDatabase("test");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		MongoIterable<String> tables = database.listCollectionNames();
		Product ürün= new Product();
		for(String coll : tables){///databasedeki ürünleri List'lerin içine alýyor.
								/// ürünler için redis'te tutulan tweetler yoksa o ürün için tweetleri alýyor
			
			
			MongoCollection<Document> table = database.getCollection(coll.toString());///Database'deki her bir koleksiyonu tek tek alýyor
			FindIterable<Document> aaa=table.find();/// her koleksiyon içindeki documentleri listeye alýyor
			
			 ÜrünSeçici seç = new ÜrünSeçici();
			 ÜrünOluþturucu oluþturucu;
			 final Hesaplayan hesap1=new Hesaplayan(new EnYuksegiAl());
			    final Hesaplayan hesap2= new Hesaplayan(new OrtalamaIleHesapla());
			    
			    
			for (Document current : aaa) {/// ürünleri documentteki koleksiyon adlarýna göre
										/// ait olduklarý 
				
				switch(coll)
				{
					case "CepTelefonu":
						 ///ürün= new CellPhone( current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
						///Double.parseDouble(current.getString("Fiyati")),
						///current.getString("Kategorisi"),current.getInteger("MegaPikseli"),current.getString("Rami"));
						 
						
							 oluþturucu = seç.ürünSeç("Telefon");
							CellPhone yeniTelefon =(CellPhone) oluþturucu.ürünüOluþtur();
							yeniTelefon.setCameraSize(current.getInteger("MegaPikseli"));
							yeniTelefon.setCategoryName(current.getString("Kategorisi"));
							yeniTelefon.setpBrand(current.getString("Markasi"));
							yeniTelefon.setpId(current.getInteger("pid"));
							yeniTelefon.setpModel(current.getString("Modeli"));
							yeniTelefon.setpPrice(Double.parseDouble(current.getString("Fiyati")));
							yeniTelefon.setRamSize(current.getString("Rami"));
							ürün=yeniTelefon;
						cepTelefonuListesi.add(yeniTelefon);
						cepTelefonuListesi2.add(yeniTelefon);
						
						break;
						
					case "VersatilKalem":
						///ürün= new VersatilKalem(current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
						////	Double.parseDouble(current.getString("Fiyati")),
						///		current.getString("Kategorisi"),
						///		current.getDouble("Kalem ucu çapý:"),
						///		current.getBoolean("Ucu içine giriyor mu:"));
						 oluþturucu = seç.ürünSeç("Kalem");
						VersatilKalem yeniVersatilKalem =(VersatilKalem)oluþturucu.ürünüOluþtur();
						yeniVersatilKalem.setCategoryName(current.getString("Kategorisi"));
						yeniVersatilKalem.setKalemUcu(current.getDouble("Kalem ucu çapý:"));
						yeniVersatilKalem.setpBrand(current.getString("Markasi"));
						yeniVersatilKalem.setpId(AnaMenu.toplamÜrünSayýsý);
						yeniVersatilKalem.setpModel(current.getString("Modeli"));
						yeniVersatilKalem.setpPrice(Double.parseDouble(current.getString("Fiyati")));
						yeniVersatilKalem.setUcuIcýneGider(current.getBoolean("Ucu içine giriyor mu:"));
						ürün=yeniVersatilKalem;
						versatilKalemListesi.add(yeniVersatilKalem);
						versatilKalemListesi2.add(yeniVersatilKalem);
						break;
						
					case "Yazýcý":
						////ürün =new Yazýcý(current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
						///	Double.parseDouble(current.getString("Fiyati")),
						///		current.getString("Kategorisi"),current.getBoolean("Çift Taraflý Yazdýrma")
						///		,current.getInteger("Dakikadaki  Sayfa Sayýsý"),
						///		current.getBoolean("Fotokopi çekmek"));
						oluþturucu = seç.ürünSeç("Yazýcý");
						Yazýcý yeniYazýcý= (Yazýcý)oluþturucu.ürünüOluþtur();
						yeniYazýcý.setCategoryName(current.getString("Kategorisi"));
						yeniYazýcý.setDakikadakiSayfa(current.getInteger("Dakikadaki  Sayfa Sayýsý"));
						yeniYazýcý.setFotokopi(current.getBoolean("Fotokopi çekmek"));
						yeniYazýcý.setpBrand(current.getString("Markasi"));
						yeniYazýcý.setpId(current.getInteger("pid"));
						yeniYazýcý.setpModel(current.getString("Modeli"));
						yeniYazýcý.setpPrice(Double.parseDouble(current.getString("Fiyati")));
						yeniYazýcý.setÇiftTaraflýYazma(current.getBoolean("Çift Taraflý Yazdýrma"));
						ürün=yeniYazýcý;
						yazýcýListesi.add(yeniYazýcý);
						yazýcýListesi2.add(yeniYazýcý);
						break;
					
					case "Buzdolabý":
							///ürün =new Buzdolabý(current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
							///	Double.parseDouble(current.getString("Fiyati")),
							///		current.getString("Kategorisi"),current.getInteger("Ýç Hacim Litresi")
							///		,current.getString("Verimlilik Sýnýfý"));
							
							oluþturucu = seç.ürünSeç("Buzdolabý");
							Buzdolabý yeniBuzdolabý=(Buzdolabý)oluþturucu.ürünüOluþtur();
							yeniBuzdolabý.setCategoryName(current.getString("Kategorisi"));
							yeniBuzdolabý.setIçHacimLitresi(current.getInteger("Ýç Hacim Litresi"));
							yeniBuzdolabý.setpBrand(current.getString("Markasi"));
							yeniBuzdolabý.setpId(current.getInteger("pid"));
							yeniBuzdolabý.setpModel(current.getString("Modeli"));
							yeniBuzdolabý.setpPrice(Double.parseDouble(current.getString("Fiyati")));
							yeniBuzdolabý.setVerimlilik(current.getString("Verimlilik Sýnýfý"));
							ürün=yeniBuzdolabý;
							buzdolabýListesi.add(yeniBuzdolabý);
							buzdolabýListesi2.add(yeniBuzdolabý);
							break;
						
					default:
						break;
						
				}
		        if(toplamÜrünSayýsý<ürün.getpId())
		        	toplamÜrünSayýsý=ürün.getpId();
		        
		      											

					Jedis jedis=new Jedis("127.0.0.1", 6379); 
				
			    ///System.out.println("Connection to server successfully"); 
			   /// System.out.println("Redis Server is running: "+jedis.ping());///redis serverý çalýþýyor mu diye kontrol ediyor. 
			    
			   
				///if(current.getString("Modeli").compareTo("Tikky")==0)
				//{
				//  jedis.del(current.getString("Modeli").replaceAll("\\s+","")); ///redisdeki tweetleri silmek için
				 /// {
				
			    Set<String> nicknames = jedis.smembers(current.getString("Modeli").replaceAll("\\s+",""));///ürünün Model adý hashtag olarak kullanýlarak daha önce
			    																	/// tweet toplanmýþ mý diye bakýlýyor.
			    
				
			    if(nicknames.isEmpty())///redis'te o ürün için tweet tutulmuþ mu kontrol ediyor.
			    {
			    	try {												/// ürün için daha önce rediste tweetler tutulmadýysa
						Tweets.getTweets(current.getString("Modeli").replaceAll("\\s+",""),current.getString("Markasi").replaceAll("\\s+",""));///ürün için tweetleri topluyor.
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	 nicknames = jedis.smembers(current.getString("Modeli").replaceAll("\\s+",""));///her ürün için toplanýlan tweetler redis'ten çekiliyor.
			    }
		        
			    ArrayList<String> tweetListesi= new ArrayList<String>();
			    tweetListesi.addAll(nicknames);///toplanýlan tweetler arraylist'e aktarýlýyor.
			    
			   
			   
			    ürün.setSentic(hesap1.SenticHesapla(tweetListesi));///toplanýlan tweetler kullanýlarak ürünün sentic deðeri bulunuyor
			    ürün.setSentic2(hesap2.SenticHesapla(tweetListesi));
			    System.out.println(ürün);
			    
			    
			    
			   jedis.close(); 
			    
		        
		    }///for (Document current : aaa)
		}///for (String coll : tables)
		
		Collections.sort(cepTelefonuListesi);
		Collections.sort(versatilKalemListesi);
		Collections.sort(yazýcýListesi);
		Collections.sort(buzdolabýListesi);
		Collections.sort(cepTelefonuListesi2,Product.Comparators.Sentic);
		Collections.sort(versatilKalemListesi2,Product.Comparators.Sentic);
		Collections.sort(yazýcýListesi2,Product.Comparators.Sentic);
		Collections.sort(buzdolabýListesi2,Product.Comparators.Sentic);
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaMenu frame = new AnaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 
		
		
		
		///JOptionPane.showMessageDialog(null, database.listCollections().)
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public AnaMenu() {
		setTitle("Ana Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton urunEklemeButonu = new JButton("\u00DCr\u00FCn Ekle");
		urunEklemeButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KategoriGirme form1= new KategoriGirme();
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, urunEklemeButonu, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, urunEklemeButonu, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, urunEklemeButonu, 64, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, urunEklemeButonu, 103, SpringLayout.WEST, contentPane);
		contentPane.add(urunEklemeButonu);
		
		JButton btnNewButton = new JButton("Chatbot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BotHandler form1= new BotHandler();
				form1.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, urunEklemeButonu);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 42, SpringLayout.EAST, urunEklemeButonu);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 64, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 131, SpringLayout.EAST, urunEklemeButonu);
		contentPane.add(btnNewButton);
		
		
	}
}

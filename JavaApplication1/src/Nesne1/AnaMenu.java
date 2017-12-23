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
	public static List<VersatilKalem> versatilKalemListesi = new ArrayList<VersatilKalem>();
	public static List<Yaz�c�> yaz�c�Listesi = new ArrayList<Yaz�c�>();
	public static List<Buzdolab�> buzdolab�Listesi = new ArrayList<Buzdolab�>();
	public static int toplam�r�nSay�s� =0;
	
	
	///MongoDB Atlas'a ba�lan�yor
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
		Product �r�n= new Product();
		for(String coll : tables){///databasedeki �r�nleri List'lerin i�ine al�yor.
								/// �r�nler i�in redis'te tutulan tweetler yoksa o �r�n i�in tweetleri al�yor
			
			
			MongoCollection<Document> table = database.getCollection(coll.toString());///Database'deki her bir koleksiyonu tek tek al�yor
			FindIterable<Document> aaa=table.find();/// her koleksiyon i�indeki documentleri listeye al�yor
			
			for (Document current : aaa) {/// �r�nleri documentteki koleksiyon adlar�na g�re
										/// ait olduklar� 
				
				switch(coll)
				{
					case "CepTelefonu":
						 �r�n= new CellPhone( current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
						Double.parseDouble(current.getString("Fiyati")),
						current.getString("Kategorisi"),current.getInteger("MegaPikseli"),current.getString("Rami"));
						cepTelefonuListesi.add((CellPhone)�r�n);
						
						break;
						
					case "VersatilKalem":
						�r�n= new VersatilKalem(current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
							Double.parseDouble(current.getString("Fiyati")),
								current.getString("Kategorisi"),
								current.getDouble("Kalem ucu �ap�:"),
								current.getBoolean("Ucu i�ine giriyor mu:"));
						versatilKalemListesi.add((VersatilKalem)�r�n);
						break;
						
					case "Yaz�c�":
						�r�n =new Yaz�c�(current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
							Double.parseDouble(current.getString("Fiyati")),
								current.getString("Kategorisi"),current.getBoolean("�ift Tarafl� Yazd�rma")
								,current.getInteger("Dakikadaki  Sayfa Say�s�"),
								current.getBoolean("Fotokopi �ekmek"));
						yaz�c�Listesi.add((Yaz�c�)�r�n);
						break;
					
					case "Buzdolab�":
							�r�n =new Buzdolab�(current.getInteger("pid"),current.getString("Markasi"),current.getString("Modeli"),
								Double.parseDouble(current.getString("Fiyati")),
									current.getString("Kategorisi"),current.getInteger("�� Hacim Litresi")
									,current.getString("Verimlilik S�n�f�"));
							buzdolab�Listesi.add((Buzdolab�)�r�n);
							break;
						
					default:
						break;
						
				}
		        if(toplam�r�nSay�s�<�r�n.getpId())
		        	toplam�r�nSay�s�=�r�n.getpId();
		        
		      											

					Jedis jedis=new Jedis("127.0.0.1", 6379); 
				
			    ///System.out.println("Connection to server successfully"); 
			   /// System.out.println("Redis Server is running: "+jedis.ping());///redis server� �al���yor mu diye kontrol ediyor. 
			    
			   
				///if(current.getString("Modeli").compareTo("Tikky")==0)
				//{
				//  jedis.del(current.getString("Modeli").replaceAll("\\s+","")); ///redisdeki tweetleri silmek i�in
				 /// {
				
			    Set<String> nicknames = jedis.smembers(current.getString("Modeli").replaceAll("\\s+",""));///�r�n�n Model ad� hashtag olarak kullan�larak daha �nce
			    																	/// tweet toplanm�� m� diye bak�l�yor.
			    
				
			    if(nicknames.isEmpty())///redis'te o �r�n i�in tweet tutulmu� mu kontrol ediyor.
			    {
			    	try {												/// �r�n i�in daha �nce rediste tweetler tutulmad�ysa
						Tweets.getTweets(current.getString("Modeli").replaceAll("\\s+",""),current.getString("Markasi").replaceAll("\\s+",""));///�r�n i�in tweetleri topluyor.
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	 nicknames = jedis.smembers(current.getString("Modeli").replaceAll("\\s+",""));///her �r�n i�in toplan�lan tweetler redis'ten �ekiliyor.
			    }
		        
			    ArrayList<String> tweetListesi= new ArrayList<String>();
			    tweetListesi.addAll(nicknames);///toplan�lan tweetler arraylist'e aktar�l�yor.
			    SenticNet yeni= new SenticNet();
			    �r�n.setSentic(yeni.kutupDegerHesapla(tweetListesi));///toplan�lan tweetler kullan�larak �r�n�n sentic de�eri bulunuyor
			    System.out.println(�r�n);
			    
			   jedis.close(); 
			    
		        
		    }///for (Document current : aaa)
		}///for (String coll : tables)
		
		Collections.sort(cepTelefonuListesi);
		Collections.sort(versatilKalemListesi);
		Collections.sort(yaz�c�Listesi);
		Collections.sort(buzdolab�Listesi);
		
		
		
		
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

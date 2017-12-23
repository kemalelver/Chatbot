package Nesne1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SenticNet {
	
	private static HashMap<String, Double> senticNet = new HashMap<String, Double>();
	
	public SenticNet() ///senticnet4.txt dosyasýndan kutup deðerleri alýnarak HashMap'e atýlýyor.
	{
		Scanner sc2 = null;
		
		
		try {
			sc2 = new Scanner(new File("senticnet4.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("senticnet4.txt açýlmadý");
		}
	    
		
		///System.out.println("açýldý");
	    String key=" ";
	    Double deger;
	    
	           
	        while (sc2.hasNext()) {
	             key = sc2.next();
	             ///System.out.println(key);        
	             sc2.next();         
	             deger = Double.parseDouble(sc2.next());
	  
	            senticNet.put(key, deger);
	            
	            
	        }
	        
	    
	    sc2.close();
	}
	
	public  double kutupDegerHesapla(ArrayList<String> tweetListesi)
	{
		double deðer=0;
		double toplamDeðerliKelimeSayýsý=0;
		int kelimeSayisi=0, döngü;
		String aranan="";
		
		for(String tweet :tweetListesi)
		{
			
			String[] parçalanmýþ= tweet.split("\\s+");
			kelimeSayisi=parçalanmýþ.length;
			döngü=0;
			for(String parça: parçalanmýþ)
			{
				
				
				
				aranan=parçalanmýþ[döngü].toLowerCase();
				 for(int i=döngü+1;i<kelimeSayisi && i<6; i++)///senticnet te birden fazla kelimeden oluþan keylerin deðerlerini almak
																///için kullandým.a_lot_of_ tarzý olanlar için
				{
					 
					if(senticNet.containsKey(aranan))
					{
						toplamDeðerliKelimeSayýsý++;
						deðer+=senticNet.get(aranan);
						
						
					}
					aranan+='_'+parçalanmýþ[i].toLowerCase();
					///System.out.println(aranan+"   "+deðer+"   aaaaa"+döngü); /// tweetleri doðru bölüyor mu diye baktým
				}
				
				döngü++;
			
				
				
			}
		}
		////System.out.println(deðer+"   "+toplamDeðerliKelimeSayýsý);
		return deðer/toplamDeðerliKelimeSayýsý;
	}

}

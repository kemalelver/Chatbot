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
	
	public SenticNet() ///senticnet4.txt dosyas�ndan kutup de�erleri al�narak HashMap'e at�l�yor.
	{
		Scanner sc2 = null;
		
		
		try {
			sc2 = new Scanner(new File("senticnet4.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("senticnet4.txt a��lmad�");
		}
	    
		
		///System.out.println("a��ld�");
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
		double de�er=0;
		double toplamDe�erliKelimeSay�s�=0;
		int kelimeSayisi=0, d�ng�;
		String aranan="";
		
		for(String tweet :tweetListesi)
		{
			
			String[] par�alanm��= tweet.split("\\s+");
			kelimeSayisi=par�alanm��.length;
			d�ng�=0;
			for(String par�a: par�alanm��)
			{
				
				
				
				aranan=par�alanm��[d�ng�].toLowerCase();
				 for(int i=d�ng�+1;i<kelimeSayisi && i<6; i++)///senticnet te birden fazla kelimeden olu�an keylerin de�erlerini almak
																///i�in kulland�m.a_lot_of_ tarz� olanlar i�in
				{
					 
					if(senticNet.containsKey(aranan))
					{
						toplamDe�erliKelimeSay�s�++;
						de�er+=senticNet.get(aranan);
						
						
					}
					aranan+='_'+par�alanm��[i].toLowerCase();
					///System.out.println(aranan+"   "+de�er+"   aaaaa"+d�ng�); /// tweetleri do�ru b�l�yor mu diye bakt�m
				}
				
				d�ng�++;
			
				
				
			}
		}
		////System.out.println(de�er+"   "+toplamDe�erliKelimeSay�s�);
		return de�er/toplamDe�erliKelimeSay�s�;
	}

}

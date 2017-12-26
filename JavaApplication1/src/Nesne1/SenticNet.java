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
	
	
	
	
	///Singleton Deseni Kullanýmý için
	private static SenticNet TekSenticNet = new SenticNet();
	
	
	
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



	public static HashMap<String, Double> getSenticNet() {
		return senticNet;
	}



	public static void setSenticNet(HashMap<String, Double> senticNet) {
		SenticNet.senticNet = senticNet;
	}
	


}

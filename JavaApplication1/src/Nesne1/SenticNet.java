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
	
	
	
	
	///Singleton Deseni Kullan�m� i�in
	private static SenticNet TekSenticNet = new SenticNet();
	
	
	
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



	public static HashMap<String, Double> getSenticNet() {
		return senticNet;
	}



	public static void setSenticNet(HashMap<String, Double> senticNet) {
		SenticNet.senticNet = senticNet;
	}
	


}

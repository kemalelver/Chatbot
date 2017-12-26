package Strategy;

import java.util.ArrayList;

import Nesne1.SenticNet;

public class EnYuksegiAl implements SenticHesaplamaYontemi {

	public double senticHesapla(ArrayList<String> tweetListesi)
	{
		double de�er=0;
		double senticDe�eri=0;
		int kelimeSayisi=0, d�ng�;
		String aranan="";
		
		for(String tweet :tweetListesi)
		{
			
			String[] par�alanm��= tweet.split("\\s+");
			kelimeSayisi=par�alanm��.length;
			d�ng�=0;
			de�er=0;
			for(String par�a: par�alanm��)
			{
				
				
				
				aranan=par�alanm��[d�ng�].toLowerCase();
				 for(int i=d�ng�+1;i<kelimeSayisi && i<6; i++)///senticnet te birden fazla kelimeden olu�an keylerin de�erlerini almak
																///i�in kulland�m.a_lot_of_ tarz� olanlar i�in
				{
					 
					if(SenticNet.getSenticNet().containsKey(aranan))
					{
						
						de�er+=SenticNet.getSenticNet().get(aranan);
						
						
						
					}
					aranan+='_'+par�alanm��[i].toLowerCase();
					///System.out.println(aranan+"   "+de�er+"   aaaaa"+d�ng�); /// tweetleri do�ru b�l�yor mu diye bakt�m
				}
				
				d�ng�++;
				
			
				
				
			}
			
			if(senticDe�eri<de�er)
				senticDe�eri=de�er;
		}
		
		return senticDe�eri;
	}

}

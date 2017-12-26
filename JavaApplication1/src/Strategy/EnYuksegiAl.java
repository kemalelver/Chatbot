package Strategy;

import java.util.ArrayList;

import Nesne1.SenticNet;

public class EnYuksegiAl implements SenticHesaplamaYontemi {

	public double senticHesapla(ArrayList<String> tweetListesi)
	{
		double deðer=0;
		double senticDeðeri=0;
		int kelimeSayisi=0, döngü;
		String aranan="";
		
		for(String tweet :tweetListesi)
		{
			
			String[] parçalanmýþ= tweet.split("\\s+");
			kelimeSayisi=parçalanmýþ.length;
			döngü=0;
			deðer=0;
			for(String parça: parçalanmýþ)
			{
				
				
				
				aranan=parçalanmýþ[döngü].toLowerCase();
				 for(int i=döngü+1;i<kelimeSayisi && i<6; i++)///senticnet te birden fazla kelimeden oluþan keylerin deðerlerini almak
																///için kullandým.a_lot_of_ tarzý olanlar için
				{
					 
					if(SenticNet.getSenticNet().containsKey(aranan))
					{
						
						deðer+=SenticNet.getSenticNet().get(aranan);
						
						
						
					}
					aranan+='_'+parçalanmýþ[i].toLowerCase();
					///System.out.println(aranan+"   "+deðer+"   aaaaa"+döngü); /// tweetleri doðru bölüyor mu diye baktým
				}
				
				döngü++;
				
			
				
				
			}
			
			if(senticDeðeri<deðer)
				senticDeðeri=deðer;
		}
		
		return senticDeðeri;
	}

}

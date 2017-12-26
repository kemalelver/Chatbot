package Strategy;

import java.util.ArrayList;

import Nesne1.SenticNet;

public class OrtalamaIleHesapla implements SenticHesaplamaYontemi {

	public double senticHesapla(ArrayList<String> tweetListesi)
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
					 
					if(SenticNet.getSenticNet().containsKey(aranan))
					{
						toplamDeðerliKelimeSayýsý++;
						deðer+=SenticNet.getSenticNet().get(aranan);
						
						
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

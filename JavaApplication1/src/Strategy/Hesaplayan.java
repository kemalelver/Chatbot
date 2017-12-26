package Strategy;

import java.util.ArrayList;

public class Hesaplayan {

	private final SenticHesaplamaYontemi Yontem;
	
	public Hesaplayan(final SenticHesaplamaYontemi Yontem)
	{
		this.Yontem=Yontem;
	}
	
	public double SenticHesapla(ArrayList<String> tweetListesi)
	{
		return Yontem.senticHesapla(tweetListesi);
	}
}

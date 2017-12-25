package Nesne1.FabrikaDeseni;

public class ÜrünSeçici {

	public ÜrünOluşturucu ürünSeç(String tipi)
	{
		switch(tipi)
		{
		case "Buzdolabı":
			return new BuzdolabıOluştur();
		case "Kalem":
			return new KalemOlustur();
			
		case "Telefon":
			return new CepTelefonuOlustur();
			
		case "Yazıcı":
			return new YazıcıOlustur();
			default:
				break;
		
		}
		return new BuzdolabıOluştur();
	}
}

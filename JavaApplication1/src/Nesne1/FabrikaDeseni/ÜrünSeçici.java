package Nesne1.FabrikaDeseni;

public class ÜrünSeçici {

	public ÜrünOluþturucu ürünSeç(String tipi)
	{
		switch(tipi)
		{
		case "Buzdolabý":
			return new BuzdolabýOluþtur();
			
			default:
				break;
		}
		return new BuzdolabýOluþtur();
	}
}

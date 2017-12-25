package Nesne1.FabrikaDeseni;

import Nesne1.Buzdolabý;
import Nesne1.Product;

public class BuzdolabýOluþtur implements ÜrünOluþturucu{
	
	@Override
	public Product ürünüOluþtur()
	{
		return new Buzdolabý();
	}

	

}

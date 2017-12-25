package Nesne1.FabrikaDeseni;

import Nesne1.Product;
import Nesne1.Yazıcı;

public class YazıcıOlustur implements ÜrünOluşturucu {

	@Override
	public Product ürünüOluştur()
	{
		return new Yazıcı();
	}
}

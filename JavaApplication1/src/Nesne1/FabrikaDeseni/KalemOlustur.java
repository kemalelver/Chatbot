package Nesne1.FabrikaDeseni;

import Nesne1.Product;
import Nesne1.VersatilKalem;

public class KalemOlustur implements ÜrünOluþturucu {

	@Override
	public Product ürünüOluþtur()
	{
		return new VersatilKalem();
	}

}

package Nesne1.FabrikaDeseni;

import Nesne1.CellPhone;
import Nesne1.Product;

public class CepTelefonuOlustur implements ÜrünOluþturucu{
	
	@Override
	public Product ürünüOluþtur()
	{
		return new CellPhone();
	}
}

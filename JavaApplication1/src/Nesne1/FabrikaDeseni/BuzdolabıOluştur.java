package Nesne1.FabrikaDeseni;

import Nesne1.Buzdolabı;
import Nesne1.Product;

public class BuzdolabıOluştur implements ÜrünOluşturucu{
	
	@Override
	public Product ürünüOluştur(int pId, String pBrand, String pModel,double pPrice)
	{
		return new Product(pId,pBrand,pModel,pPrice);
	}

	static public void ürünüDeğiştir( Buzdolabı yeni,String categoryName, int içHacimLitresi, String verimlilik)
	{
		yeni.setCategoryName(categoryName);
		yeni.setIçHacimLitresi(içHacimLitresi);
		yeni.setVerimlilik(verimlilik);
	}

}

package Nesne1.FabrikaDeseni;

import Nesne1.Buzdolab�;
import Nesne1.Product;

public class Buzdolab�Olu�tur implements �r�nOlu�turucu{
	
	@Override
	public Product �r�n�Olu�tur(int pId, String pBrand, String pModel,double pPrice)
	{
		return new Product(pId,pBrand,pModel,pPrice);
	}

	static public void �r�n�De�i�tir( Buzdolab� yeni,String categoryName, int i�HacimLitresi, String verimlilik)
	{
		yeni.setCategoryName(categoryName);
		yeni.setI�HacimLitresi(i�HacimLitresi);
		yeni.setVerimlilik(verimlilik);
	}

}

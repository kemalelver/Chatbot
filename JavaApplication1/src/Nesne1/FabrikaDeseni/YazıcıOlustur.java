package Nesne1.FabrikaDeseni;

import Nesne1.Product;
import Nesne1.Yaz�c�;

public class Yaz�c�Olustur implements �r�nOlu�turucu {

	@Override
	public Product �r�n�Olu�tur()
	{
		return new Yaz�c�();
	}
}

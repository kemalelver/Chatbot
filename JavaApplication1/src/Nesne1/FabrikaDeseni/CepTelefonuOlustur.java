package Nesne1.FabrikaDeseni;

import Nesne1.CellPhone;
import Nesne1.Product;

public class CepTelefonuOlustur implements �r�nOlu�turucu{
	
	@Override
	public Product �r�n�Olu�tur()
	{
		return new CellPhone();
	}
}

package Nesne1.FabrikaDeseni;

import Nesne1.Product;
import Nesne1.VersatilKalem;

public class KalemOlustur implements �r�nOlu�turucu {

	@Override
	public Product �r�n�Olu�tur()
	{
		return new VersatilKalem();
	}

}

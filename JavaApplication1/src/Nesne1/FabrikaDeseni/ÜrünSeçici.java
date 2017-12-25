package Nesne1.FabrikaDeseni;

public class �r�nSe�ici {

	public �r�nOlu�turucu �r�nSe�(String tipi)
	{
		switch(tipi)
		{
		case "Buzdolab�":
			return new Buzdolab�Olu�tur();
		case "Kalem":
			return new KalemOlustur();
			
		case "Telefon":
			return new CepTelefonuOlustur();
			
		case "Yaz�c�":
			return new Yaz�c�Olustur();
			default:
				break;
		
		}
		return new Buzdolab�Olu�tur();
	}
}

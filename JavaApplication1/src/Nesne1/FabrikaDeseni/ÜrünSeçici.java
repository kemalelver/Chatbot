package Nesne1.FabrikaDeseni;

public class �r�nSe�ici {

	public �r�nOlu�turucu �r�nSe�(String tipi)
	{
		switch(tipi)
		{
		case "Buzdolab�":
			return new Buzdolab�Olu�tur();
			
			default:
				break;
		}
		return new Buzdolab�Olu�tur();
	}
}

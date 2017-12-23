package Nesne1;

public class VersatilKalem extends Category {
	private double kalemUcu;
	private boolean ucuIc�neGider;
	
	public VersatilKalem(int pId, String brand, String model, double pPrice , String categoryName, double kalemUcu, boolean ucuIc�neGider) {
		
		super(pId, brand, model,pPrice,categoryName);
		this.kalemUcu = kalemUcu;
		this.ucuIc�neGider= ucuIc�neGider;
		
	}

	public double getKalemUcu() {
		return kalemUcu;
	}

	public void setKalemUcu(double kalemUcu) {
		this.kalemUcu = kalemUcu;
	}

	public boolean isUcuIc�neGider() {
		return ucuIc�neGider;
	}

	public void setUcuIc�neGider(boolean ucuIc�neGider) {
		this.ucuIc�neGider = ucuIc�neGider;
	}
	@Override
	public String toString()
	{
		return super.toString()+" --Versatil Kalem [Kalem Ucu=" + kalemUcu + ", Ucu i�ine gider=" + ucuIc�neGider + "]";
	}
}

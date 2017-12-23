package Nesne1;

public class VersatilKalem extends Category {
	private double kalemUcu;
	private boolean ucuIcýneGider;
	
	public VersatilKalem(int pId, String brand, String model, double pPrice , String categoryName, double kalemUcu, boolean ucuIcýneGider) {
		
		super(pId, brand, model,pPrice,categoryName);
		this.kalemUcu = kalemUcu;
		this.ucuIcýneGider= ucuIcýneGider;
		
	}

	public double getKalemUcu() {
		return kalemUcu;
	}

	public void setKalemUcu(double kalemUcu) {
		this.kalemUcu = kalemUcu;
	}

	public boolean isUcuIcýneGider() {
		return ucuIcýneGider;
	}

	public void setUcuIcýneGider(boolean ucuIcýneGider) {
		this.ucuIcýneGider = ucuIcýneGider;
	}
	@Override
	public String toString()
	{
		return super.toString()+" --Versatil Kalem [Kalem Ucu=" + kalemUcu + ", Ucu içine gider=" + ucuIcýneGider + "]";
	}
}

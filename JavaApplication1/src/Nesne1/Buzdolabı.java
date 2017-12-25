package Nesne1;

public class Buzdolab� extends Category {
	
	private int i�HacimLitresi;
	private String verimlilik;
	
	public Buzdolab�(int pId, String brand, String model, double pPrice , String categoryName, int i�HacimLitresi, String verimlilik )
	{
		super(pId, brand, model, pPrice, categoryName);
		this.i�HacimLitresi= i�HacimLitresi;
		this.verimlilik= verimlilik;
	}


	public Buzdolab�()
	{
		super();
		
	}
	public int getI�HacimLitresi() {
		return i�HacimLitresi;
	}


	public void setI�HacimLitresi(int i�HacimLitresi) {
		this.i�HacimLitresi = i�HacimLitresi;
	}


	public String getVerimlilik() {
		return verimlilik;
	}


	public void setVerimlilik(String verimlilik) {
		this.verimlilik = verimlilik;
	}


	@Override
	public String toString() {
		return super.toString() + " --Buzdolab� [�� Hacim Litresi=" + i�HacimLitresi + ", verimlilik=" 
						+ verimlilik + "]";
	}

}

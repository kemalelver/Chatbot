package Nesne1;

public class Buzdolabż extends Category {
	
	private int iÁHacimLitresi;
	private String verimlilik;
	
	public Buzdolabż(int pId, String brand, String model, double pPrice , String categoryName, int iÁHacimLitresi, String verimlilik )
	{
		super(pId, brand, model, pPrice, categoryName);
		this.iÁHacimLitresi= iÁHacimLitresi;
		this.verimlilik= verimlilik;
	}


	public int getIÁHacimLitresi() {
		return iÁHacimLitresi;
	}


	public void setIÁHacimLitresi(int iÁHacimLitresi) {
		this.iÁHacimLitresi = iÁHacimLitresi;
	}


	public String getVerimlilik() {
		return verimlilik;
	}


	public void setVerimlilik(String verimlilik) {
		this.verimlilik = verimlilik;
	}


	@Override
	public String toString() {
		return super.toString() + " --Buzdolabż [›Á Hacim Litresi=" + iÁHacimLitresi + ", verimlilik=" 
						+ verimlilik + "]";
	}

}

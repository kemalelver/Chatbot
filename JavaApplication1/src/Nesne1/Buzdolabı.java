package Nesne1;

public class Buzdolabı extends Category {
	
	private int içHacimLitresi;
	private String verimlilik;
	
	public Buzdolabı(int pId, String brand, String model, double pPrice , String categoryName, int içHacimLitresi, String verimlilik )
	{
		super(pId, brand, model, pPrice, categoryName);
		this.içHacimLitresi= içHacimLitresi;
		this.verimlilik= verimlilik;
	}


	public Buzdolabı()
	{
		super();
		
	}
	public int getIçHacimLitresi() {
		return içHacimLitresi;
	}


	public void setIçHacimLitresi(int içHacimLitresi) {
		this.içHacimLitresi = içHacimLitresi;
	}


	public String getVerimlilik() {
		return verimlilik;
	}


	public void setVerimlilik(String verimlilik) {
		this.verimlilik = verimlilik;
	}


	@Override
	public String toString() {
		return super.toString() + " --Buzdolabı [İç Hacim Litresi=" + içHacimLitresi + ", verimlilik=" 
						+ verimlilik + "]";
	}

}

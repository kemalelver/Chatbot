package Nesne1;

public class Yazıcı extends Category{
	
	private boolean çiftTaraflıYazma;
	private int dakikadakiSayfa;
	private boolean fotokopi;
	
	public Yazıcı(int pId, String brand, String model, double pPrice , String categoryName, boolean çiftTaraflıYazma, int dakikadakiSayfa, boolean fotokopi )
	{
		super(pId, brand, model, pPrice, categoryName);
		this.çiftTaraflıYazma=çiftTaraflıYazma;
		this.dakikadakiSayfa=dakikadakiSayfa;
		this.fotokopi=fotokopi;
		
	}
	
	@Override
	public String toString() {
		return super.toString() + " --Yazıcı [Çift taraflı yazdırma=" + çiftTaraflıYazma + ", Dakikadaki Sayfa Sayısı=" + dakikadakiSayfa + ",fotokopi="+ fotokopi+ "]";
	}



}

package Nesne1;

public class Yazıcı extends Category{
	
	public boolean isÇiftTaraflıYazma() {
		return çiftTaraflıYazma;
	}

	public void setÇiftTaraflıYazma(boolean çiftTaraflıYazma) {
		this.çiftTaraflıYazma = çiftTaraflıYazma;
	}

	public int getDakikadakiSayfa() {
		return dakikadakiSayfa;
	}

	public void setDakikadakiSayfa(int dakikadakiSayfa) {
		this.dakikadakiSayfa = dakikadakiSayfa;
	}

	public boolean isFotokopi() {
		return fotokopi;
	}

	public void setFotokopi(boolean fotokopi) {
		this.fotokopi = fotokopi;
	}

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
	
	public Yazıcı() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String toString() {
		return super.toString() + " --Yazıcı [Çift taraflı yazdırma=" + çiftTaraflıYazma + ", Dakikadaki Sayfa Sayısı=" + dakikadakiSayfa + ",fotokopi="+ fotokopi+ "]";
	}



}

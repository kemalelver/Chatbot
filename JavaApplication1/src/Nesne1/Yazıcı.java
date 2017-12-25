package Nesne1;

public class Yaz�c� extends Category{
	
	public boolean is�iftTarafl�Yazma() {
		return �iftTarafl�Yazma;
	}

	public void set�iftTarafl�Yazma(boolean �iftTarafl�Yazma) {
		this.�iftTarafl�Yazma = �iftTarafl�Yazma;
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

	private boolean �iftTarafl�Yazma;
	private int dakikadakiSayfa;
	private boolean fotokopi;
	
	public Yaz�c�(int pId, String brand, String model, double pPrice , String categoryName, boolean �iftTarafl�Yazma, int dakikadakiSayfa, boolean fotokopi )
	{
		super(pId, brand, model, pPrice, categoryName);
		this.�iftTarafl�Yazma=�iftTarafl�Yazma;
		this.dakikadakiSayfa=dakikadakiSayfa;
		this.fotokopi=fotokopi;
		
	}
	
	public Yaz�c�() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String toString() {
		return super.toString() + " --Yaz�c� [�ift tarafl� yazd�rma=" + �iftTarafl�Yazma + ", Dakikadaki Sayfa Say�s�=" + dakikadakiSayfa + ",fotokopi="+ fotokopi+ "]";
	}



}

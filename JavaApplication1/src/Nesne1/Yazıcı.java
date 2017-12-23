package Nesne1;

public class Yaz�c� extends Category{
	
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
	
	@Override
	public String toString() {
		return super.toString() + " --Yaz�c� [�ift tarafl� yazd�rma=" + �iftTarafl�Yazma + ", Dakikadaki Sayfa Say�s�=" + dakikadakiSayfa + ",fotokopi="+ fotokopi+ "]";
	}



}

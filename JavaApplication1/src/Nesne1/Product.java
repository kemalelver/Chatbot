package Nesne1;

import java.text.DecimalFormat;
import java.util.Comparator;

public class Product implements Comparable<Product>{
		private int pId;
		private String pBrand;
		private String pModel;
		private double pPrice;
		private double sentic;
		private double sentic2;

		public double getSentic2() {
			return sentic2;
		}

		public void setSentic2(double sentic2) {
			this.sentic2 = sentic2;
		}

		public double getSentic() {
			return sentic;
		}

		public void setSentic(double sentic) {
			this.sentic = sentic;
		}

		public Product() {

		}

		public Product(int pId, String pBrand, String pModel,double pPrice) {
			
			this.pId = pId;
			this.pBrand = pBrand;
			this.pModel = pModel;
			this.pPrice=pPrice;
		}
		@Override
		public int compareTo(Product other) {
			if(this.sentic==other.sentic)  
				return 0;  
				else if(this.sentic<other.sentic)  
				return 1;  
				else  
				return -1;  
		}

		public static class Comparators {
			
			public static Comparator<Product> Sentic = new Comparator<Product>() {
	            
	            public int compare(Product o1, Product o2) {
	            	if(o1.sentic2==o2.sentic2)  
	    				return 0;  
	    				else if(o1.sentic2<o2.sentic2)  
	    				return 1;  
	    				else  
	    				return -1;  
	            }
	        };
		}
		

		public int getpId() {
			return pId;
		}

		public void setpId(int pId) {
			this.pId = pId;
		}

		public String getpBrand() {
			return pBrand;
		}

		public void setpBrand(String pBrand) {
			this.pBrand = pBrand;
		}

		public String getpModel() {
			return pModel;
		}

		public void setpModel(String pModel) {
			this.pModel = pModel;
		}

		@Override
		public String toString() {
			DecimalFormat df = new DecimalFormat("#.00");
			DecimalFormat df1 = new DecimalFormat("#0.000");
			return  String.format("Product [pId=%-2s pBrand=%-16s pModel=%-14s", pId,pBrand,pModel)+ ", Price="+df.format(pPrice)+ " ,Sentic:"+ df1.format(sentic)+ 
					", Sentic2:"+df1.format(sentic2)
					+ "]";
		}

		public double getpPrice() {
			return pPrice;
		}

		public void setpPrice(double pPrice) {
			this.pPrice = pPrice;
		}



}

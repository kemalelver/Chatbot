package Nesne1;

public class Category extends Product{
	
	private String categoryName;

	public Category(int pId, String pBrand, String pModel, double pPrice, String categoryName)
	{
		super(pId,pBrand,pModel, pPrice);
		this.categoryName=categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return super.toString()+"--Category= [ CategoryName= "+categoryName+ " ]";
	
	}
}

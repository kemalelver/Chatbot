package Nesne1;


public class CellPhone extends Category {
	private int cameraSize;
	private String ramSize;

	public CellPhone(int pId, String brand, String model, double pPrice , String categoryName, int cameraSize, String ramSize) {
		super(pId, brand, model,pPrice,categoryName);
		this.cameraSize = cameraSize;
		this.ramSize = ramSize;
	}

	public CellPhone() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getCameraSize() {
		return cameraSize;
	}

	public void setCameraSize(int cameraSize) {
		this.cameraSize = cameraSize;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	@Override
	public String toString() {
		return super.toString() + " --CellPhone [cameraSize=" + cameraSize + ", ramSize=" + ramSize + "]";
	}

}

public class Product {
	private int productID;
	private String productName;
	private double productPrice;
	private String productDesc;
	
	public Product() {}
	
	public Product(String productName, double productPrice, String productDesc) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
}

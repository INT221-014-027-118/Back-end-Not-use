package RefunGarantee.Int221.Model;

public class Mouse {

	private int productId;
	private String productName;
	private double price;
	private String description;
	private String brandName;
	private String type;
//	private String color[];

	public Mouse() {
	}

	public Mouse(int productId, String productName, double price, String description, String brandName, String type) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;

		this.brandName = brandName;
		this.type = type;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

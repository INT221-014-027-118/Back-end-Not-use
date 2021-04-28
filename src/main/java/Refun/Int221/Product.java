package Refun.Int221;

public class Product {
	private int productId;
	private String productName;
	private double price;
	private String description;
	private int brandId;
	private int typeId;
	private int warranty;
	private String luanchDate;
	private String imageUrl;

	public Product() {
	}

	public Product(int productId, String productName, double price, String description, int brandId, int typeId,
			int warranty, String luanchDate, String imageUrl) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.brandId = brandId;
		this.typeId = typeId;
		this.warranty = warranty;
		this.luanchDate = luanchDate;
		this.imageUrl = imageUrl;
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

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public String getLuanchDate() {
		return luanchDate;
	}

	public void setLuanchDate(String luanchDate) {
		this.luanchDate = luanchDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}

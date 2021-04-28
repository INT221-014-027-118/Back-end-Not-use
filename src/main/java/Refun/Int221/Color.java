package Refun.Int221;

public class Color {

	private int colorId;
	private String colorName;
	private String hexColor;

	public Color() {

	}

	public Color(int colorId, String colorName, String hexColor) {

		this.colorId = colorId;
		this.colorName = colorName;
		this.hexColor = hexColor;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getHexColor() {
		return hexColor;
	}

	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}

}

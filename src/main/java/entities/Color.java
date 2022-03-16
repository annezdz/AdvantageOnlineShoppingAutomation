package entities;

public enum Color {
	BLUE("BLUE"),
	BLACK("BLACK"),
	GRAY("GRAY"),
	PURPLE("PURPLE"),
	RED("RED"),
	YELLOW("YELLOW");
	
	
	
	private String color;

	public String getColor() {
		return this.color;
	}
	
	private Color(String color) {
		this.color = color;
	}
}

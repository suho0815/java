package chapter5;

public class Armor {
	
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	
	public void setHeight(int value) {
		height = value;
	}
	
	public int getHeight() {
		return height;
	}

	public void setName() {
		String value = "mark6";
		name = value;
	}
	
	public String getName() {
		
		if (name == null)
			return "NO Name";
		
		return name;
	}
	
}

package com.roadtovalhalla.games.lagertha.render.colors;

public enum Color {
	RED("1,0,0"),
	GREEN("0,1,0"),
	BLUE("0,0,1"),
	WHITE("1,1,1"),
	BLACK("0,0,0"),
	YELLOW("255, 255, 0");
	
	private final RGB rgb;
	private final static String VALUE_SEPARATOR = ",";
	
	private Color(final String code){
		String[] array = code.split(VALUE_SEPARATOR);
		this.rgb = new RGB(Float.valueOf(array[0]), Float.valueOf(array[1]), Float.valueOf(array[2]));
	}
	
	public RGB getRGB(){
		return rgb;
	}
}

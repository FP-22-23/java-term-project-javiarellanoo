package fp.types;

public record Complexion(String race, String hairColour, String skin, String eyes){
	
	public String getShortFormat() {
		return "Race= " + race() + ", Hair Colour = " + hairColour() + ", Skin Colour = " + skin() + ", Eye Colour = " + eyes();
	}
	}

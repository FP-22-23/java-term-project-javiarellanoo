package fp.types;

public record Complexion(String race, String hairColour, String skin, String eyes){
	public Complexion(String race, String hairColour, String skin, String eyes) {
		if(race!= "-") {
			this.race = race;}
			else {
				this.race = "Not available";}
		if(hairColour != "-") {
			this.hairColour = hairColour;
		}
		else {
			this.hairColour = "Not available";}
		if(skin!= "-") {
			this.skin = skin;}
			else {
				this.skin = "Not available";}
		if(eyes!= "-") {
			this.eyes = skin;}
			else {
				this.eyes = "Not available";}
		
		}
	public String getShortFormat() {
		return "Race= " + race() + ", Hair Colour = " + hairColour() + ", Skin Colour = " + skin() + ", Eye Colour = " + eyes();
	}
	}

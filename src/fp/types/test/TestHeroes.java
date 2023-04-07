package fp.types.test;

import fp.types.*;

public class TestHeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     HeroesImpl heroes = HeroesFactory.readHeroes("heroes_information.csv");

	      System.out.println("There are " + heroes.getNumberHeroes() 
	            + " heroes in the file");
		

	}

}

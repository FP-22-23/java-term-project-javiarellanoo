package fp.types.test;

import fp.types.*;

public class TestHeroes {
	
	private static Heroes heroes = HeroesFactory.readHeroes("./data/heroes_information.csv");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testNumberHeroes();
		testforEach("Telepathy");
		testforAll(2);
		testCounter("blue");
		testSum();
		testAverage();
		testFilter("Telepathy");
		testMapCollection();
		testMapInteger();
		
		

	}
	
	private static void testNumberHeroes() {
	      System.out.println("There are " + heroes.getNumberHeroes() 
          + " heroes in the file");
	      System.out.println("The first 5 entries are " + heroes.getHeroes().subList(0,4));
	}
	
	private static void testforEach(String p) {
		System.out.println("Do any of the heroes posses the power " + p + "?: " + heroes.isThereAHeroWithPower(p));
	}
	private static void testforAll(Integer a) {
		System.out.println("Are all heroes older than " + a+ " years old? " + heroes.areAllHeroesOlderThan(a));
	}
	private static void testCounter(String c) {
		System.out.println(heroes.howManyHeroesHaveEyes(c) + " heroes have " +c +" eyes");
	}
	private static void testSum() {
		System.out.println("The sum of the weight of all good heroes is : " + heroes.allGoodHeroesWeight() + " kg");
	}
	private static void testAverage() {
		System.out.println("The average height of all heroes is : " + heroes.computeAverageHeight() + " cm");
	}
	private static void testFilter(String f) {
		System.out.println("The heroes with power " + f+ " are: \n " + heroes.getHeroesWithCertainPower(f));
	}
	private static void testMapCollection() {
		System.out.println("The heroes grouped by their hair color are: " + heroes.getHeroesbyHairColor());
		}
	private static void testMapInteger() {
		System.out.println("The number of heroes by race are: " + heroes.getNumberHeroesByRace());
	}
	}


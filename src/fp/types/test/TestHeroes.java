package fp.types.test;

import fp.types.*;

public class TestHeroes {
	
	private static Heroes heroes = HeroesFactory.readHeroes("./data/heroes_information.csv");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testNumberHeroes();
		testforEach("Telepathy");
		testforAll(2);
		testCounter("red");
		testSum();
		testAverage();
		testFilter("Telepathy");
		testMapCollection();
		testMapInteger();
		testExistsStream("Telepathy");
		testforAllStream(10);
		testCounterStream("red");
		testSumStream();
		testAverageStream();
		testFilterStream("Telepathy");
		testMaximumFiltering("Telepathy");
		testMinimumFiltering("Human");
		testOrderedSelection(Publisher.DARK_HORSE);
		testMapping();
		testMapIntegerS();
		testGroupingBy();
		testMaximumProperty();
		testSortedMap((long)3);
		testMapEntry();
		
		
		
		

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
	private static void testExistsStream(String p) {
		System.out.println("Do any of the heroes posses the power " + p + "?: " + heroes.isThereAHeroS(p));
	}
	private static void testforAllStream(Integer a) {
		System.out.println("Are all heroes older than " + a+ " years old? " + heroes.areAllHeroesOlderThanS(a));
	}
	private static void testCounterStream(String c) {
		System.out.println(heroes.howManyHeroesHaveEyesS(c) + " heroes have " +c +" eyes");
	}
	private static void testSumStream() {
		System.out.println("The sum of the weight of all good heroes is : " + heroes.allGoodHeroesWeightS() + " kg");
	}
	private static void testAverageStream() {
		System.out.println("The average height of all heroes is : " + heroes.allHeroesAverageHeightS() + " cm");
	}
	private static void testFilterStream(String f) {
		System.out.println("The heroes with power " + f+ " are: \n " + heroes.getHeroesWithCertainPowerS(f));
	}
	private static void testMaximumFiltering(String p) {
		System.out.println("The hero with more powers, that among them posseses " + p + " is " + heroes.maximumNumberOfPowersHero(p).getName());
	}
	private static void testMinimumFiltering(String r) {
		System.out.println("The youngest hero of the race " + r + " is " + heroes.minimumAgeHero(r));
	}
	private static void testOrderedSelection(Publisher p) {
		System.out.println("All heroes under the publisher " + p + " ordered by their age are: " + "\n " + heroes.HeroesByPublisherandAge(p));
	}
	private static void testMapping() {
		System.out.println("All heroes grouped by their hair colour: " + heroes.getHeroesByHairColorS());	
	}
	private static void testMapIntegerS() {
	System.out.println("The number of heroes by race are: " + heroes.getNumberHeroesByRaceS());
	}
	private static void testGroupingBy() {
	System.out.println("The heroes with the greatest number of powers by publisher : " + heroes.getHeroesMostPowers());
	}
	private static void testMaximumProperty() {
		System.out.println("The heaviest hero by publisher: " + heroes.getHeaviestHerobyPublisher());
	}
	private static void testSortedMap(Long n) {
		System.out.println("The n tallest hero by race are: " + heroes.getNTallestHeroesbyRace(n));
	}
	private static void testMapEntry() {
		System.out.println("The publisher that has the hero with less powers, alongside that hero is: "+  heroes.getPairSmallestNumberOfPowers());
	}
	}


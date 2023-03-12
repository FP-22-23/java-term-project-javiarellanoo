package fp.test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.types.*;
public class TestHero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We will first try to test the Hero Class, by doing so, we will be checking our auxiliary type as well.
		//First we will check the constructor for Complexion and Hero
		Complexion c = new Complexion("Human", "Redhead", "fair skin", "green");
		Hero h1 = new Hero("Scarlet Witch", Gender.FEMALE, 165, 65, true, c, LocalDate.of(1989, 2, 25), Publisher.MARVEL);
		
		//We now check the second Constructor
		Complexion c2 = new Complexion("Human", "Black Hair", "fair skin", "brown");
		Hero h2 = new Hero("Iron-Man", Gender.MALE, true, c2);
		
		h1.addPower("Telekinesis");
		//We create a List and add elements to check the method addPowers
		List<String> ps = new ArrayList<>();
		ps.add("Super Strength");
		ps.add("Mecha Armour");
		ps.add("Flight");
		
		h2.addPowers(ps); 
		
		//Lets check the getters and setters
		System.out.println("The gender of " + h1.getName() + " is " + h1.getGender());
		h1.setGender(Gender.MALE);
		System.out.println("The new gender of "+ h1.getName() + " is " + h1.getGender());
		
		h2.setPublisher(Publisher.MARVEL);
		System.out.println("The creator of "+ h2.getName() + " is " + h2.getPublisher());
		
		h2.setHeight(180);
		System.out.println("The height of " + h2.getName() + " is " + h2.getHeight() + " cm");
		
		h2.setWeight(90);
		System.out.println("The weight of " + h2.getName() + " is " + h2.getWeight() + " kg");
		
		h1.setAffiliation(false);
		System.out.println("Is " + h1.getName() + " a hero? " + h1.isAffiliation());
		System.out.println("Is " + h2.getName() + " a hero? " + h2.isAffiliation());
		
		
		System.out.println("The powers of " + h2.getName()+ " are " + h2.getPowers());
		
		h2.setBirth(LocalDate.of(1985, 4, 16));
		System.out.println(h2.getName() + " was born on " + h2.getBirth() + " so that he is " + h2.getAge());
		
		System.out.println("Wanda Maximoff's hero name is " + h1.getName() + " and her physical complexion is " + h1.getComplexion());
		System.out.println(h1.toString());
		
		// We now test for equality and Natural Order
		Hero h3 = h1;
		System.out.println("Are h1 and h3 equals?" + h1.equals(h3));
		System.out.println("Are h2 and h3 equals?" + h2.equals(h3));
		System.out.println(h1.compareTo(h2));
		

	}

}

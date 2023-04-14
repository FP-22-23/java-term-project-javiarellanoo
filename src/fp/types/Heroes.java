package fp.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Heroes {
	@Override
	public int hashCode() {
		return Objects.hash(heroes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heroes other = (Heroes) obj;
		return Objects.equals(heroes, other.heroes);
	}

	private List<Hero> heroes;
	
	//Creates an empty collection of heroes
	public Heroes() {
		heroes = new ArrayList<Hero>();
	}
	
	//Creates a type HeroesImpl from a collection of heroes (using collections)
	public Heroes(Collection<Hero> cheroes) {
		heroes = new ArrayList<Hero>(cheroes);
	}
	
	//Creates a type HeroesImpl from a collection of heroes using stream.
	public Heroes(Stream<Hero> sheroes) {
		heroes = sheroes.collect(Collectors.toList());
	}
	
	//BASIC OPERATIONS
	
	public Integer getNumberHeroes() {
		return heroes.size();
	}

	public List<Hero> getHeroes() {
		return heroes;
	}

	@Override
	public String toString() {
		return "HeroesImpl [heroes=" + heroes + "]";
	}
	
	public void addHero(Hero h) {
		heroes.add(h);
	}
	
	public void addHeroes(Collection<Hero> ch) {
		heroes.addAll(ch);
	}
	
	public void removeHero(Hero h) {
		heroes.remove(h);
	}
	
	// METHODS:
	
		//For each: Check if there is a hero with a certain power
	public Boolean isThereAHeroWithPower(String power) {
		Boolean res = false;
		for(Hero h: heroes) {
			if(h.getPowers().contains(power)) {
				res = true;
				break;
			}
		}
		return res;
	}
	// for All: Check if all heroes are older than a certain integer given
	public Boolean areAllHeroesOlderThan(Integer age) {
		Boolean res = true;
		for(Hero h:heroes) {
			if(h.getAge()<age) {
				res = false;
				break;
			}
		}
		return res;
	}
	
	//Counter: Count how many Heroes have eyes of a certain color;
	public Integer howManyHeroesHaveEyes(String color) {
		Integer res = 0;
		for(Hero h:heroes) {
			if(h.getComplexion().eyes().equals(color)) {
				res++;
			}
		}
		return res;
	}
	
	//Sum: Sum the weight of all heroes, if they are good:
	public Integer allGoodHeroesWeight() {
		Integer res = 0;
		for(Hero h: heroes) {
			if(h.isAffiliation()) {
				res+=h.getWeight();
			}
		}
		return res;
	}
	
	//Average: Compute the average height of all heroes:
	
	public Double computeAverageHeight() {
		Double res = 0.;
		for(Hero h: heroes) {
			res+= h.getHeight();
		}
		return res/getNumberHeroes();
		
	}
	
	// Selection with filtering:
	
	public List<String> getHeroesWithCertainPower(String power){
		List<String> res = new ArrayList<>();
		for(Hero h: heroes) {
			if(h.getPowers().contains(power)) {
				res.add(h.getName());
			}
		}
		return res;
	}
	
	// MAP Exercises: 
	
	// 1- Map with a collection as a value, in this case, a map with with key hair color, value a list of hero-names.
	
	public Map<String, List<String>> getHeroesbyHairColor(){
		Map<String, List<String>> res = new HashMap<>();
		for(Hero h: heroes) {
			if(res.keySet().contains(h.getComplexion().hairColour())) {
				res.get(h.getComplexion().hairColour()).add(h.getName());
			}
			else {
				List<String> l = new ArrayList<>();
				l.add(h.getName());
				res.put(h.getComplexion().hairColour(), l);
			}
			}
		return res;
		}
	
	//2-Map with key race and value the number of heroes that belong to that race.
	
	public Map<String, Integer> getNumberHeroesByRace(){
		Map<String, Integer> res = new HashMap<>();
		for(Hero h: heroes) {
			if(res.keySet().contains(h.getComplexion().eyes())) {
				res.put(h.getComplexion().eyes(), res.get(h.getComplexion().eyes()) +1);
			}
			else {
				res.put(h.getComplexion().eyes(), 1);
			}
		}
		return res;
}
}

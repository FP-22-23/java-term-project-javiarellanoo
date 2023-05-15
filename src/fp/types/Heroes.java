package fp.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
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
			if(res.keySet().contains(h.getComplexion().race())) {
				res.put(h.getComplexion().race(), res.get(h.getComplexion().race()) +1);
			}
			else {
				res.put(h.getComplexion().race(), 1);
			}
		}
		return res;
}
	//THIRD DELIVERY:
	//1- Exists: Checks if there is a hero with a certain power using a stream
	public Boolean isThereAHeroS (String power) {
		return this.heroes.stream().anyMatch(t->t.getPowers().contains(power));
	}
	//1- For all: Checks if all heroes are older than an age given using a stream
	public Boolean areAllHeroesOlderThanS (Integer age) {
		return this.heroes.stream().allMatch(t->t.getAge()>age);
	}
	//2- Counter: Counts the number of heroes with a certain eye color, using streams
	public Long howManyHeroesHaveEyesS(String e) {
		return this.heroes.stream().filter(t->t.getComplexion().eyes().equals(e)).count();
	}
	//2- Sum: Sum the weight of all heroes if they are good
	public Long allGoodHeroesWeightS() {
		return this.heroes.stream().filter(t->t.isAffiliation()).mapToLong(t->t.getWeight()).sum();
	}
	//2- Average: Computes the average weight of all Heroes
	public Double allHeroesAverageHeightS() {
		return this.heroes.stream().mapToDouble(t->t.getHeight()).average().orElse(0.0);
	}
	//3- Filtering: Using streams, I will filter super-heroes based on whether they have a power p
	public List<String> getHeroesWithCertainPowerS (String p) {
		return this.heroes.stream().filter(t->t.getPowers().contains(p)).map(t->t.getName()).toList();
	}
	//4- Maximum with Filtering: We obtain the maximum of  a list of heroes that have one power.
	public Hero maximumNumberOfPowersHero (String p) {
		return this.heroes.stream().filter(t->t.getPowers().contains(p)).max(Comparator.comparing(t->t.getPowers().size())).orElse(null);
	}
	//4- Minimum with filtering: We obtain the hero with the minimum age that belongs to a certain race.
	public Hero minimumAgeHero (String r) {
		return this.heroes.stream().filter(t->t.getComplexion().race().equals(r)).min(Comparator.comparing(t->t.getAge())).orElse(null);
	}
	//5- Selection with filtering and ordering: We obtain all the heroes from a publisher, sorted by their age.
	public List<Hero> HeroesByPublisherandAge(Publisher p){
		return this.heroes.stream().filter(t->t.getPublisher().equals(p)).sorted(Comparator.comparing(t->t.getAge())).toList();
	}
	//Block 2 of the Third Delivery:
	
	//6.1- Exercise 4 of the second delivery using streams
	public Map<String, List<String>> getHeroesByHairColorS(){
		return this.heroes.stream().collect(Collectors.groupingBy(t->t.getComplexion().hairColour(),Collectors.mapping(Hero::getName, Collectors.toList())));
	}
	//6.2- Exercise 5 of the second delivery using streams
	public Map<String, Long> getNumberHeroesByRaceS(){
		return this.heroes.stream().collect(Collectors.groupingBy(t->t.getComplexion().race(), Collectors.counting()));
	}
	
	//7- Method that groups the heroes with the greatest number of powers by Publisher
	public Map<Publisher, Hero> getHeroesMostPowers(){
		Comparator<Hero> c = Comparator.comparing(t->t.getPowers().size());
		  return heroes.stream().collect(Collectors.groupingBy(Hero::getPublisher,Collectors.collectingAndThen(Collectors.maxBy(c),opt->opt.orElse(null))));
	}
	//8- Map in which the keys are the properties of the object Hero and each key is the hero with the minimum value of said property.
	public Map<Publisher, String> getHeaviestHerobyPublisher(){
		Map<Publisher, List<Hero>> aux = this.heroes.stream().collect(Collectors.groupingBy(x->x.getPublisher(), Collectors.toList()));
		return aux.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->getHeaviestHero(e.getValue())));
	}
	private String getHeaviestHero(List<Hero> i) {
		return i.stream().max(Comparator.comparing(Hero::getWeight)).map(Hero::getName).orElse(null);
	}
	//Ask
	//9- SortedMap that Groups the elements by their race and gives the n tallest heroes 
	public SortedMap<String, List<String>> getNTallestHeroesbyRace(Long n) {
		  SortedMap<String, List<Hero>> aux = heroes.stream().collect(Collectors.groupingBy(h->h.getComplexion().race(),()-> new TreeMap<String, List<Hero>>(Comparator.naturalOrder()), Collectors.toList()));
		  Map<String, List<String>> res = aux.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e-> getTallestHeroes(n, e.getValue())));
		  return new TreeMap<>(res);
	}
	private List<String> getTallestHeroes(Long n, List<Hero> h){
		return h.stream().sorted(Comparator.comparing(Hero::getHeight)).map(Hero::getName).limit(n).toList();
	}
	//10-Returns the entry with the smallest number of powers
	public Map.Entry<Publisher, Hero> getPairSmallestNumberOfPowers(){
		Map<Publisher, List<Hero>> aux = this.heroes.stream().collect(Collectors.groupingBy(x->x.getPublisher(), Collectors.toList()));
		Map<Publisher, Hero> finalMap =  aux.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->getLessPoweredHero(e.getValue())));
		return finalMap.entrySet().stream().min(Comparator.comparing(x->x.getValue().getPowers().size())).orElse(null);
		
	}
	private Hero getLessPoweredHero(List<Hero> i) {
		return i.stream().min(Comparator.comparing(x->x.getPowers().size())).orElse(null);
	}
}

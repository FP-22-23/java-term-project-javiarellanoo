package fp.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroesImpl {
	private List<Hero> heroes;
	
	//Creates an empty collection of heroes
	public HeroesImpl() {
		heroes = new ArrayList<Hero>();
	}
	
	//Creates a type HeroesImpl from a collection of heroes (using collections)
	public HeroesImpl(Collection<Hero> cheroes) {
		heroes = new ArrayList<Hero>(cheroes);
	}
	
	//Creates a type HeroesImpl from a collection of heroes using stream.
	public HeroesImpl(Stream<Hero> sheroes) {
		heroes = sheroes.collect(Collectors.toList());
	}
	
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
	

}

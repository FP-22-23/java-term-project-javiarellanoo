package types;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utils.Checkers;

public class Hero implements Comparable<Hero> {
	private String name;
	private Gender gender;
	private Publisher publisher;
	private Integer height;
	private Integer weight;
	private boolean affiliation;//Will return true if it is good and  false if it is evil
	private Complexion complexion;
	private List<String> powers;
	private LocalDate birth;
	public Hero(String n, Gender g, Integer h, Integer w, boolean a, Complexion c, LocalDate birth, Publisher p) {
		Checkers.check("The hero must have a name", !n.isBlank());
		Checkers.check("Weight and height must be positive", h>=0 && w>=0);
		this.name = n;
		this.gender = g;
		this.height = h;
		this.weight = w;
		this.affiliation = a;
		this.complexion = c;
		this.birth = birth;
		this.publisher = p;
		this.powers = new ArrayList<>();
	}
	
	public Hero(String n, Gender g,boolean a, Complexion c) {
		Checkers.check("The hero must have a name", !n.isBlank());
		this.name = n;
		this.gender = g;
		this.affiliation =a;
		this.complexion = c;
		this.height = null;
		this.weight = null;
		this.birth = null;
		this.powers = new ArrayList<>();
		this.publisher = null;
}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		Checkers.check("Weight and height must be positive", height>0);
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		Checkers.check("Weight and height must be positive", weight>0);
		this.weight = weight;
	}

	public boolean isAffiliation() {
		return affiliation;
	}

	public void setAffiliation(boolean affiliation) {
		this.affiliation = affiliation;
	}

	public List<String> getPowers() {
		return powers;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Integer getAge() {
		return getBirth().until(LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}

	public Complexion getComplexion() {
		return complexion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birth, name, publisher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		return Objects.equals(birth, other.birth) && Objects.equals(name, other.name) && publisher == other.publisher;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", gender=" + gender + ", publisher=" + publisher + ", height=" + height
				+ ", weight=" + weight + ", is it a hero?=" + affiliation + ", Complexion(" + complexion.getShortFormat() +" )" + ", Number of powers="
				+ getPowers().size() + ", Age=" + getAge() + "]";
	}
	
	public void addPower(String p) {
		powers.add(p);
	}
	public void addPowers(List<String> ps) {
		powers.addAll(ps);
	}
	
	public int compareTo(Hero h) {
		int res = getName().compareTo(h.getName());
		if (res==0) {
			res= getGender().compareTo(h.getGender());
		}
		return res;
	}
	
	
}
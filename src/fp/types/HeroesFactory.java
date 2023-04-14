package fp.types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utils.Checkers;

public class HeroesFactory {
	
	public static Heroes readHeroes(String fileName) {
		Heroes heroes = null;
		try {
			Stream<Hero> h = Files.lines(Paths.get(fileName)).skip(1).map(HeroesFactory::parseLine);
			heroes = new Heroes(h);		
			}catch(IOException e){
				System.out.println("Error with the file" + fileName);
				e.printStackTrace();
			}
			return heroes;
	}
	
	public static Hero parseLine(String line) {
	    String[] values = line.split(";");
		Checkers.check("Format line error", values .length==12);
		String name = values[0].trim();
		Gender gender = parseGender(values[1].trim().toUpperCase());
		Integer height = parseWH(values[5].trim());
		Complexion c = new Complexion(values[3].trim(), values[4].trim(), values[7].trim(), values[2].trim());
		Publisher p = parsePublisher(values[6].trim());
		Boolean affiliation = parseAff(values[8].trim());
		Integer weight = parseWH(values[9].trim());
		LocalDate birthdate = LocalDate.parse(values[10].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		List<String> powers = parsePowers(values[11]);
		
		return new Hero(name, gender, height, weight, affiliation, c, birthdate, p, powers);
		
		
		
	}
	public static Publisher parsePublisher(String p) {
		Publisher pub = Publisher.OTHER;
		if(p.equals("Marvel Comics")) {
			pub = Publisher.MARVEL;
		}
		else if(p.equals("DC Comics")) {
			pub = Publisher.DC;
		}
		else if(p.equals("Dark Horse Comics")) {
			pub = Publisher.DARK_HORSE;
		}
		return pub;
	}

	public static Boolean parseAff(String a) {
		Boolean res = false;
		if(a.equals("good")) {
			res = true;
		}
		return res;
	}
	public static List<String> parsePowers(String powers){
	    String[] values = powers.split(",");
	    List<String> l = new ArrayList<>();
	    for(String v:values) {
	    	l.add(v);
	    }
	    return l;    
	}
	
	public static Integer parseWH(String wh) {
		Integer res = null;
		if(wh.equals("Indefinite")) {
			res = 0;
		}
		else {
			res = Integer.valueOf(wh);
		}
		return res;
	}
	public static Gender parseGender(String g) {
		Gender gen = null;
		if(g.equals("-")) {
			gen = Gender.NOT_AVAILABLE;
		}
		else {
			gen = Gender.valueOf(g);}
		return gen;
	}
}

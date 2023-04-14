# Project of the Second Term. Fundamentals of Programming(Curso 2022/23)
Author: Javier Arellano López   uvus:KMJ4890

## Structure of the project's folders:

* **/src**: Directory with the source code
  * **types**: Package that contains the classes of the project
  * **test**: Package that contains the test classes of the project
  * **utils**:  Package that contains the utility classes needed to implement certain functions.
* **/data**: Contains the data set for the project
    * **heros_information.csv**: CSV file that contains the data for my project
    
## *Dataset Structure*

The original dataset can be obtained from the following URL [https://www.kaggle.com/datasets/claudiodavi/superhero-set]. However, it has been severely modified to satisfy the conditions stablished by the instructor. Some data was fixed in order to make procedures easier and others were added, such as the column named "Powers" and the one containing the dates.

Now, all columns are detailed:

* **name**: of type string, indicates the hero identity of the character.
* **gender**: of type enum, can take the values Male, Female or Not Defined.
* **Eye Colour. Race, Hair Colour, Skin Colour**: of type string each, that will form the Complexion auxiliary type.
* **Height**: of type integer, the height of the character in cm.(Some of them have the string Indefinite, that will be considered as 0)
* **Publisher**: of type enum, can take the values Marvel, DC, Dark Horse or other.
* **Alignment**: of type boolean, will return true if the character is a hero or false if it is a villain.
* **Weight**: of type integer, the weight of the character in kg.(Some of them have the string Indefinite, that will be considered as 0)
* **Birth Date**: of type date, randomly generated, it indicates the date of birth of each character.
* **Powers**: of type string, separated by commas to generate a list later on. This column was obtained through modifying the second csv file that you can find in the url. It contained a huge list of boolean values, with the columns indicating the possesion of that certain power. It has been modified to have a format like:
"Super Speed, Super Strength...". This column has been created by me, making use of previous knowledge on Python and the creation of two functions that took the information from the other file, as intended.

## Implemented Types

The types that have been implemented on the project are the following

### Base Type - Hero
Represents a comic hero
**Properties**:

- _name_, of type _String_, consultable. Indicates the name of the hero.
- _gender_, of type _Gender_, consultable and modifiable. Indicates the gender of the character. Can take the values MALE, FEMALE, NOT_AVAILABLE
- _publisher_, of type _Publisher, consultable and modifiable. Indicates the creator of the hero. Can take the values MARVEL, DC, DARK_HORSE, OTHER.
- _height_, of type _Integer_, consultable and modifiable. Contains the height of the character
- _weight_, of type _Integer_, consultable and modifiable. Contains the weight of the character
- _affiliation_, of type _Boolean_, consultable and modifiable. Contains whether the character is good or evil.
- _complexion_, of type _Complexion_, consultable. Contains the physical aspect of the character.
- _powers_, of type _List\<String\>_, consultable. Contains the powers of said hero.
- _birth_, of type _LocalDate_, consultable and modifiable. Indicates the birth date of the character.
- _Age_, of type _Integer_, consultable and derived. Contains the age of the character.

**Constructors**: 

- C1: Has a parameter for every basic property of the object, except for powers.
- C2: Creates an object of type ```Hero``` from the following parameters: ```String n, Gender g, boolean a, Complexion c```.

**Restricciones**:
 
- R1: The character needs to have a name, a string different than ""(empty string).
- R2: The weight has to be greater than zero.
- R3: The height has to be greater than zero.

**Equality and Ordenation**

* ***Equality criterion***: Two heroes are equal if they have the same name, gender and publisher.
* ***Natural order***: By name and gender.

**Other operations**:

- _void addPower(String p)_: Adds p to the powers attribute if it is not contained in it already.
- _void addPowers(List<String> ps)_: Adds all the powers contained in ps to the powers attribute if they are not contained in it already.

#### Auxiliary Types

- Publisher, enumerated. Can take the values MARVEL, DC, DARK_HORSE, OTHER.
- Gender, enumerated. Can take the vales MALE, FEMALE, NOT_AVAILABLE.
- Complexion, record. Contains the skin colour, race, eye colour and hair colour of the character.
 
### Factory - HeroesFactory
 Factory- type class to create objects of type Heroes:
 - _Heroes readHeroes(String fileName)_:Creates an object of type Heroes from the information file, whose route is passed as a parameter.
 
 -_Hero parseLine(String line)_: Creates an object of type Hero from each line of the information file.
 
 -_Publisher parsePublisher(String p)_: Parses the string received to one of the possible values of the enum. Publisher.
 
 -_Boolean parseAff(String a)_: Parses the string received to a boolean value depending on whether it takes good or bad as value.
 
 -_List<String> parsePowers(String power)_: Parses a string by splitting it by commas and adding each value to a List.
 
 -_Integer parseWH(String wh)_: Parses a string into an Integer using the method valueOf, however it takes into account the "Indefinite" string contained in the file by making it 0.
 
 -_Gender parseGender(String g)_: Parses the string received to one of the possible values of the enum. Gender.
 
 ### Container Type- Heroes
 
**Constructors**: 

- C1: Creates an empty collection.
- C2: Creates an object of type ```Heroes``` from the following parameter: ```Collection<Hero>```.
- C1: Creates an object of type ```Heroes``` from a stream.


**Equality Criterion**:
Two Heroes objects are equal if they contain the same heroes.

**Other operations**:
- _Integer getNumberHeroes()_: Returns the number of elements of type Hero in the container.
- Autogenerated getter, toString and equality criterion
- _Void addHero(Hero h)_: Adds a hero to the collection
- _Void addHeroes(Collection<Hero>)_: Adds all elements of type Hero in the container passed as a parameter to the container type.
- _Void removeHero(Hero h)_: Removes a hero from the collection
- _Boolean isThereAHeroWithPower(String power)_: Returns true if there exists a hero with a certain power.
- _Boolean areAllHeroesOlderThan(Integer age)_: Checks if all heroes are older than a certain integer given, then it returns true.
- _Integer howManyHeroesHaveEyes(String color)_: Counts how many Heroes have eyes of a certain color.
- _Integer allGoodHeroesWeight()_: Sums the weight of all heroes, if they are good.
- _Double computeAverageHeight()_: Computes the average height of all heroes.
- _List<String> getHeroesWithCertainPower(String power)_: Filters the heroes by checking whether they posess a certain power.
- _Map<String, List<String>> getHeroesbyHairColor()_: Returns a map where the keys are the hair color and the keys are a list of heroes with that hair color.
- _Map<String, Integer> getNumberHeroesByRace()_: Returns a map where the keys are the races that the heroes belong to and the keys are the number of heroes belonging to that race


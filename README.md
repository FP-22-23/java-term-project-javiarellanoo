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

Note: The first column of the data set contains integer numbers in order, from 0 to 667, indicating the number given to the hero alphabetically, but it will be no relevant for the project by the moment.

* **name**: of type string, indicates the hero identity of the character.
* **gender**: of type enum, can take the values Male, Female or Not Defined.
* **Eye Colour. Race, Hair Colour, Skin Colour**: of type string each, that will form the Complexion auxiliary type.
* **Height**: of type integer, the height of the character in cm.(Some of them have the string Indefinite, that will be considered as 0)
* **Publisher**: of type enum, can take the values Marvel, DC, Dark Horse or other.
* **Alignment**: of type boolean, will return true if the character is a hero or false if it is a villain.
* **Weight**: of type integer, the weight of the character in kg.(Some of them have the string Indefinite, that will be considered as 0)
* **Birth Date**: of type date, randomly generated, it indicates the date of birth of each character.
* **Powers**: of type string, separated by commas to generate a list later on. This column was obtained through modifying the second csv file that you can find in the url. It contained a huge list of boolean values, with the columns indicating the possesion of that certain power. It has been modified to have a format like:
"Super Speed, Super Strength...". It has not yet been fully implemented since I am working on it manually and it is not required for this submission's coding.

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
- Complexion, class. Contains the skin colour, race, eye colour and hair colour of the character.

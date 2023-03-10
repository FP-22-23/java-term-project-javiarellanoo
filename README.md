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

* **rated**: de tipo booleano,  indica si las partidas han sido calificadas o no, es decir si
son partidas amistosas o de tipo clasificatorio.
* **victory_status**: de tipo cadena, indica el tipo de victoria. Puede tomar los valores: outoftime, resign, mate or draw.
* **winner**: de tipo cadena, indica el resultado de la partida. Puede tomar los valores: white, black o draw, para indicar si ganan las blancas, las negras, o hay tablas.
* **white_id**: de tipo cadena, contiene el identificador del jugador de blancas.
* **white_rating**: de tipo entero, tiene el valor ELO del jugador de blancas. El valor ELO es un número que se usa en lichess.com para hacer un ranking de los jugadores.
* **black_id**: de tipo cadena, contiene el identificador del jugador de negras.
* **black_rating**: de tipo entero, tiene el valor ELO del jugador de negras. 
* **moves**: de tipo cadena, contiene una secuencia con los movimientos de la partida. Los movimientos están separados por espacios en blanco. Por ejemplo, ```d4 d5 c4 c6 cxd5 e6 dxe6 fxe6 Nf3 Bb4+ Nc3 Ba5 Bf4```.
* **opening_name**: de tipo cadena, indica la salida y la defensa de la partida. Esto no se
corresponde con el primer o segundo movimiento, sino que son las salidas y sus distintas variantes, por ejemplo, ```Queen's Pawn Game: Mason Attack```.
* **fecha**: de tipo fecha. Indica la fecha en la que se jugó la partida.
* **duracion**: de tipo entero. Indica la duración en minutos de la partida.

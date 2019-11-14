
@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como gestor del sistema quiero poder modificar especialidades
    Given Tengo el nombre y la duracion de una especialidad "<nombre>","<duracion>","<N_duracion>"
    Given creo la especialidad "<Response>"
    Given La especialidad ha sido guardada "<nombre>","<duracion>","<response>"
    When modifico la especialidad nombre"<nombre>",duracion"<duracion>",nueva duracion"<N_duracion>", response"<response>"
    Then la especialidad ha sido modificada correctamente nombre "<nombre>", nueva duracion "<N_duracion>","<response>"
    
Examples:
	|nombre         | duracion   |N_duracion|response           |
	| Podología     |   15       |10        | OK                |
	|               |   20       |5         | Error             |
	| 1234          |   20       |20        | Error             |
	|E12            |   5        |25        | Error             |
	|Cabecera       |   15       |-1        | Error             |
	|Cabecera       |   A        |10        | Error             |
	|Oncología      |   0        |14        | Error             |
	|Podología      |            |20        | Error             |
	|Oncología      |   -1       |15        | Error             |

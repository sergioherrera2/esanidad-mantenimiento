
@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como gestor del sistema quiero poder crear especialidades
    Given Tengo el nombre y la duracion de una especialidad "<nombre>","<duracion>"
    Given creo la especialidad "<Response>"
    Given La especialidad ha sido guardada "<nombre>","<duracion>","<response>"
    When borro la especialidad "<nombre>","<duracion>","<response>"
    Then la especialidad ha sido borrada correctamente nombre "<nombre>", duracion "<duracion>","<response>"
    
Examples:
	|nombre         | duracion               |response             |
	| Podología     |   15                   | OK                  |
	|               |   20                   | Error               |
	| 1234          |   20                   | Error               |
	|E12            |   5                    | Error               |
	|Cabecera       |   15                   | OK                  |
	|Cabecera       |   A                    | Error               |
	|Oncología      |   0                    | Error               |
	|Podología      |                        | Error               |
	|Oncología      |   -1                   | Error               |



@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como gestor del sistema quiero poder crear especialidades a traves de una petición web
    Given ClienteHttpEspecialidad
    When Envio peticion eliminar especialidad nombre "<nombre>",duracion "<duracion>",response "<response>"
    Then Recibo una respuesta "<Response>", nombre "<nombre>",duracion "<duracion>"
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

@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Entro en la vista del gestor
  
  Given Abroo Firefox y entro en la aplicacion citas
  And Entro en la vista del gestor dni"<768766579C>" contraseña "<password>"
  When relleno los campos nombre "<nombre>", duracion "<duracion>"
    Then La especialidad ha sido guardada "<nombre>","<duracion>","<response>"
    Then borro la especialidad "<nombre>","<duracion>","<response>"
    
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




@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como gestor del sistema quiero poder crear especialidades a traves de la web
    Given Tengo el nombre y la duracion de una especialidad "<Especialidad Prueba>","<25>"
  Given creo la especialidad "<OK>"
   Given Abroo Firefox y entro en la aplicacion citas
   And Entro en la vista del gestor dni"<768766579C>" contraseña "<password>"
   When Presiono el boton eliminar especialidad y recibo respuesta "<response>"
   Then la especialidad se ha borrado nombre "<nombre>",duracion"<duracion>",response"<response>"
  
  
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
	

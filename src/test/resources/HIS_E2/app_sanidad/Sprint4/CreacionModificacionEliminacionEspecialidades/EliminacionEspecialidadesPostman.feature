
@tag
Feature: Eliminar una especialidad Postman

  @tag1
  Scenario Outline: Como administrador del sistema quiero poder eliminar Especialidades (Web)
   Given Tengo dni "<dni>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>"
    And creo la especialidad "<response>"
    Given ClienteHttpEspecialidad
    When Envio peticion eliminar especialidad dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
    Then Recibo una respuesta  dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
   Then la especialidad ha sido borrada correctamente dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
Examples:
	|dni           | duracion     |hora_inicio| hora_final       |response             |
	|especialidadTestA|   15         |  9:00     | 14:00            | OK                  |
	|                 |   20         |  9:00     | 14:00            | Error               |
	| 1234            |   20         |  9:00     |14:00             | Error               |
	|E12              |   5          |  9:00     | 14:00            | Error               |
	|05726279S        |   15         |  9:00     |14:00             | OK                  |
	|05726279S         |    A         |  9:00     |14:00             | Error               |
	|05726279S        |   0          |  9:00     |14:00             | Error               |
	|05726279S        |              |  9:00     |14:00             | Error               |
	|05726279S        |    -1        |  9:00     |14:00             | Error               |
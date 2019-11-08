@tag
Feature: Modificar Cita

  @tag1
  Scenario Outline: Como usuario quiero que el servidor modifique una cita
    Given Una modificaciónde cita con todos los campos dni-user "<dni-user>" , especialidad "<especialidad>", fecha "<fecha>", nueva fecha "<fecha>"
    When modifico la cita "<Result>"
    Then Se modifica  correctamente la cita dni-user "<dni-user>" , especialidad "<especialidad>", fecha "<nueva fecha>" Result "<Result>"
    And Borro la cita si ha sido insertada con exito "<dni-user>", especialidad "<especialidad>", fecha "<nueva fecha>"
    Examples: 
	|dni-user     | especialidad   | fecha antigua   | nueva fecha      | Response |
	|05726690N    | Cabezera       |10/12/2019 16:30 | 12/12/2019 17:30 | OK       |
	|05726690     | Cabezera       |10/12/2019 16:30 | 21/12/2019 16:30 | Error    |
	|05726691J    |                |10/12/2019 17:30 | 20/12/2019 17:30 | Error    |
	|05726692Z    | Hola           | 10/12/2019 24:00| 19/12/2019 17:30 | Error    |
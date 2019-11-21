
@tag
Feature: Eliminar una Especialidad Manager

  @tag1
  Scenario Outline: Como administrador del sistema quiero poder eliminar citas (Manager)
      Given Tengo dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
    Given creo la relacion "<Response>"
		Given la relacion ha sido guardada dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
   When borro la relacion dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
    Then la relacion ha sido borrada "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
    
Examples:
    | dni-user   | dni-medico  |  Response  |
    |05726690N   |05707785J    |    OK      |
    |            |05707785J    | Error      |
    |05726690N   |             | Error      |
    |            |             | Error      |
    |05726690    |05707785J    | Error      |
    |05726690N   |05707785     | Error      |
    |057266904N  |05707785J    | Error      |
    |05726690N   |057077852J   | Error      |
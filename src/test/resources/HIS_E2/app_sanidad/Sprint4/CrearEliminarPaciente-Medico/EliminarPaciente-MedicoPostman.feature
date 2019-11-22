@tag
Feature: Eliminar una especialidad Postman

  @tag1
  Scenario Outline: Como administrador del sistema quiero poder eliminar citas (Web)
     Given Tengo dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
    And creo la relacion "<Response>"
    Given ClienteHttpMedicoPaciente
    When Envio peticion eliminar relacion dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
    Then la relacion ha sido guardada dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
    Then la relacion ha sido borrada "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
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
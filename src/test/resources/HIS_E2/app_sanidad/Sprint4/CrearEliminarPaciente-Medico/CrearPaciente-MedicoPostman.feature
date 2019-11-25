#
#
#
#@tag
#Feature: Creación de una relacion Medico-Paciente
#
#  @tag1
#  Scenario Outline: Como administrador quiero crear una relacion Medico-Paciente (Web)
#    Given ClienteHttpMedicoPaciente
#    When Envio peticion crear MedicoPaciente dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
#    Then Recibo una respuesta  dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
#    Then la relacion ha sido guardada dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
#    Then borro la relacion dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
#
#Examples:
#    | dni-user   | dni-medico  |  Response  |
#    |05726690N   |05707785J    |    OK      |
#    |            |05707785J    | Error      |
#    |05726690N   |             | Error      |
#    |            |             | Error      |
#    |05726690    |05707785J    | Error      |
#    |05726690N   |05707785     | Error      |
#    |057266904N  |05707785J    | Error      |
#    |05726690N   |057077852J   | Error      |
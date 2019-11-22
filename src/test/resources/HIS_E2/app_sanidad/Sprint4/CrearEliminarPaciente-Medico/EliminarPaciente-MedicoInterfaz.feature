
@tag
Feature: Eliminar relacion  paciente medico

  @tag1
  Scenario Outline: Como administrador quiero crear una relacion medico paciente (Vista)
   Given Tengo dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"
   When creo la relacion "OK"
  Given Abroo Firefox y entro en la aplicacion
  And Entro en la vista del administrador dni "768766579C" contraseña "password"
  When presiono boton eliminar relacion medico paciente
  Then elimino relacion medico paciente dni-user "<dni-user>" "<dni-medico>"
  Then borro la relacion dni-user "<dni-user>", dni-medico "<dni-medico>", Response "<Response>"

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


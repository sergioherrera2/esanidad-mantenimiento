#
#@tag
#Feature: Pedir cita Interfaz Gestor
#
#  @tag1
#  Scenario Outline: Como gestor quiero pedir una cita
#    Given Abroo Firefox y entro en la aplicacion cita
#    And Me autentico como gestor dni "<98276278S>" pwd "<Pedro123>"
#    When Pido una cita como gestor dni-user "<dni-user>", especialidad "<especialidad>", fecha "<fecha>"
#    Then Recibo una respuesta de gestor  cita "<Response>"
#    And Borro la cita si ha sido insertada con exito "<dni-user>", especialidad "<especialidad>", fecha "<fecha>"
#
#    Examples: 
#      | dni-user   | especialidad   |  fecha              |  Response  |
#      |05726690N   | Oncología      |20/12/2019 16:35:00  |   OK       |
#      |05726690    | Cabecera       |10/12/2019 16:30:00  | Error      |
#      |05726690N   |                |10/12/2019 16:30:00  | Error      |
#      |05726690N   | Hola           |10/12/2019 16:30:00  | Error      |
#      |05726690N   | Cabecera       |                     | Error      |
#
#@tag
#Feature: Como usuario quiero pedir una cita
#    @tag2
#     Scenario Outline: Quiero poder enviar peticiones web al servidor para pedir cita
#     Given ClienteHttpPedirCita
#     When Envío petición Post con todos los campos de pedir cita dni-user "<dni-user>", especialidad "<especialidad>" , fecha "<fecha>"
#     Then Recibo una respuesta de cita Result "<Result>" dni-user "<dni-user>", especialidad "<especialidad>" , fecha "<fecha>"
#     And Borro la cita si ha sido insertada con exito "<dni-user>", especialidad "<especialidad>", fecha "<fecha>"#ç
#
#    Examples: 
#      | dni-user   | especialidad   |  fecha              |  Response  |
#      |05726690N   | Cabezera       |  10/12/2019 16:30   |   OK       |
#      |05726690    | Cabezera       |  10/12/2019 16:30   | Error      |
#      |05726690N   |                |  10/12/2019 17:30   | Error      |
#      |05726690N   | Hola           |  10/12/2019 18:30   | Error      |
#      |05726690N   | Oncología      |  10/12/2019 24:00   | Error      |
#      |05726690N   | Cabezera       |                     | Error      |
#      |05726690N   | Oncología      |  10/12/2017 18:30   | Error      |
#      |0572669N    | Oncología      | 10/12/2019 18:30    | Error      |
#      |            | Cabezera       | 10/12/2019 16:30    | Error      |
#      |05726690S   | Cabezera       | 10/12/2019 16:30    | Error      | 

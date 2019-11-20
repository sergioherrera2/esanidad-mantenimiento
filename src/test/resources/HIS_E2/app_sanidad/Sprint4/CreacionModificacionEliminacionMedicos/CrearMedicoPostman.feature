#@tag
#Feature: Crear Médico Postman
#
#  @tag1
#  Scenario Outline: Como administrador quiero crear un medcio (Web)
#    Given ClienteHttpCrearMedico
#    When Envio peticion crear medico dni "<dni>",especialidad "<especialidad>", response "<response>"
#    Then Recibo una respuesta response "<response>"
#    Then el medico ha sido guardado correctamente dni "<dni>", especialidad "<especialidad>", response "<response>"
#    Then borro el medico dni "<dni>", especialidad "<especialidad>", response "<response>"





#Examples:
#|dni       |           especialidad       |response   |
#|84675678M |     Podología                | OK        |
#|92892773N |     Homeopatía               | Error     |
#|05726690N |       f                      | Error     |
#|12345678S |     Oncología                | Error     |

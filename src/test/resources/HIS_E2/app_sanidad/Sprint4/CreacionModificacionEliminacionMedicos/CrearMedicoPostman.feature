@tag
Feature: Creación de medioc

  @tag1
  Scenario Outline: Como administrador quiero crear un medcio (Web)
    Given ClienteHttpCrearMedico
    When Envio peticion crear medico dni "<dni>",especialidad "<especialidad>", response "<response>"
    Then Recibo una respuesta response "<response>"
    Then el medico ha sido guardado correctamente dni "<dni>", especialidad "<especialidad>", response "<response>"
    Then borro el medico dni "<dni>", especialidad "<especialidad>", response "<response>"





Examples:
|dni       |           especialidad       |response   |
|84675678M |     Podología                | OK        |
|05726690N |                              | Error     |
|          |     Podología                | Error     |
|05726690N |     Farmaceutica             | Error     |

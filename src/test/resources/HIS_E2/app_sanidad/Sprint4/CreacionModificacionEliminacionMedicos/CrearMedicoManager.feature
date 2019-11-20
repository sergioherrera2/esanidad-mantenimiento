
@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como administrador quiero crear una medico (Manager)
    Given Tengo de un medico dni "<dni>", especialidad "<especialidad>"
    When creo el medico "<response>"
    Then el medico ha sido guardado correctamente dni "<dni>", especialidad "<especialidad>", response "<response>"
    Then borro el medico dni "<dni>", especialidad "<especialidad>", response "<response>"
    
Examples:
|dni       |           especialidad       |response   |
|84675678M |     Podología                | OK        |
|05726690N |                              | Error     |
|          |     Podología                | Error     |
|05726690N |     Farmaceutica             | Error     |

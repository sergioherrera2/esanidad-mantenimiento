
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given Tengo de un medico dni "<dni>", especialidad "<especialidad>"
    Given creo el medico "<response>"
    When el medico ha sido guardado correctamente dni "<dni>", especialidad "<especialidad>", response "<response>"
    Then borro el medico dni "<dni>", especialidad "<especialidad>", response "<response>"
    

Examples:
|dni       |           especialidad       |response   |
|84675678M |     Podología                | OK        |
|05726690N |                              | Error     |
|          |     Podología                | Error     |
|05726690N |     Farmaceutica             | Error     |
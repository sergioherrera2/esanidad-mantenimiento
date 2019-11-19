
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given  Tengo de un medico dni "<dni>", especialidad "<especialidad>" 
    And creo el medico "<response>"
    And ClienteHttpCrearMedico
    When Envio peticion de crear medicco dni "<dni>" , especlialidad "<especialidad>", response "<response>"
    Then Recibo una respuesta response "<response>"
    Then elmedico ha sido borrado correctamente dni "<dni>", especialdiad "<especialidad>" response "<response>"

 @tag1
  Scenario Outline: Como administrador del sistema quiero poder eliminar citas (Web)
   Given Tengo nombre "<nombre>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>"
    And creo la especialidad "<Response>"
    Given ClienteHttpEspecialidad
    When Envio peticion eliminar especialidad nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
    Then Recibo una respuesta  nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
   Then la especialidad ha sido borrada correctamente nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
Examples:
|dni       |           especialidad       |response   |
|84675678M |     Podologia                | OK        |

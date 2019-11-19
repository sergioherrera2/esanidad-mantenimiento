
@tag
Feature: Crear Medico Interfaz

  @tag2
  Scenario Outline: Como administrador quiero crear un medico
  Given Abroo Firefox y entro en la aplicacion citas
  And Entro en la vista del gestor dni"<768766579C>" contraseña "<password>"
  Then relleno los campos de creacion medico dni"<dni>" especialidad "<especialidad>"
  Then el medico ha sido guardado correctamente dni "<dni>", especialidad "<especialidad>", response "<response>"
  Then borro el medico dni "<dni>", especialidad "<especialidad>", response "<response>" 
Examples:
|dni       |           especialidad       |response   |
|84675678M |     Podologia                | OK        |



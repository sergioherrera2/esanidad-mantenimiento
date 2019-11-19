
@tag
Feature: Como administrador quiero ver la lista de especialidades

  @tag1
  Scenario: Como administrador quiero visualizar la lista de especialdiades
    Given usuario admin "<23456225C>", contrasenia "<hrW@4e1%gKac@&ipLtsY>"
    When Pido la lista de especialidades "<23456225C>"
    Then Recibo una respuesta lista de especialidades "<OK>"
    

    
  @Tag2
  Scenario: Quiero poder recibir la lista de especialidades
  Given ClienteHttpEspecialidad
  When Envio peticion recibir lista especialidades dni_admin "<23456225C>"
  Then Recibo Respuesta lista especialidades "<OK>"
 
 
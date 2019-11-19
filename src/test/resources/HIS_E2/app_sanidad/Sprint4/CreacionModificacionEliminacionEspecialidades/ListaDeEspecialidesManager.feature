
@tag
Feature: Como administrador quiero ver la lista de especialidades

  @tag1
  Scenario: Como administrador quiero visualizar la lista de especialdiades
    Given usuario admin "<23456225C>", contrasenia "<hrW@4e1%gKac@&ipLtsY>"
    When Pido la lista de especialidades "<23456225C>"
    Then Recibo una respuesta lista de especialidades "<OK>"
    
     @tag2
  Scenario: Como administrador quiero que otros usuarios no visualicen la lista de especialdiades
    Given usuario admin "<05726690N>", contrasenia "<Antonio123>"
    When Pido la lista de especialidades "<05726690N>"
    Then Recibo una respuesta lista de especialidades "<Error>"
    
    
  @Tag2
  Scenario: Quiero poder recibir la lista de especialidades
  Given ClienteHttpEspecialidad
  When Envio peticion recibir lista especialidades dni_admin "<23456225C>"
  Then Recibo Respuesta lista especialidades "<OK>"
 
 
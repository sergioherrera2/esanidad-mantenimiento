
@tag
Feature: Autencicacion como Medico

  @tag2
  Scenario Outline: Como medico quiero autenticarme
    Given un un medico "<dni>" contrasenia "<contrasenia>"
    And Abroo un buscador y entro en la aplicacion citas
#    When me autentico
#    Then presiono el boton cambiar a vista de trabajo
#    Then Cambio a vista de trabajo "<response>"
    
    
    
     Examples:
 |dni           | contrasenia     |  response |
 | 65278762R    | Albert123       | OK        |
 | 97637789Y    | Carlos123       | Error     |
 | 65278762     | Albert123       | Error     |
 | 97637789S    | Carlos123       | Error     |
 |              | Carlos123       | Error     |  
 | 65278762R    |                 | Error     |
 | 65278762Z    | Albert123       | OK        | 
  

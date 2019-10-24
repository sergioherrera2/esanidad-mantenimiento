
@tag
Feature: Autenticarse en la página web como usuario
     
     
     @tag2
     Scenario: Como usuario quiero poder enviar una peticion de cita
     Given ClienteHttpcita
     When Envío petición Post con todos los campos de cita
     Then Recibo una respuesta satisfactoria  de cita
     
     
   @tag4
  Scenario: Cita correctamente guardada
    Given  Una cita
    And Abrir Firefox y escribir url de la aplicación
    And 
    When la cita se intenta guardar
     Then la cita ha sido guardada
     
     
   @tag3
   Scenario: Como medico quiero poder ver mis citas
   Given Un medico 
   When envia peticion de visualizar citas
   Then Se recibe una respuecta satisfactoria 
     
     @tag1
  Scenario Outline: Como usuario quiero poder pedir una cita
    Given Un usuario conectado en la pagina de citas
    When Relleno todos los campos Fecha "<fecha>" , hora "<hora>" y especialidad "<especialidad>"
    Then Recibo un mensaje de cita confirmada
     

 Examples:
    | fecha               | hora        |especialidad    |     
    | 05726690N           | TGIF        |cabezera        |             
    | 05726690N           | Nope        |cabezera        |
    | 05726690N           |             |cabezera        |
  
      

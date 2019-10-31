
@tag
Feature: Title of your feature
  I want to use this template for my feature file

    @tag2
     Scenario Outline: Quiero poder enviar peticiones web al servidor para registrarme
     Given ClienteHttpRegistro
     When Envío petición Post con todos los campos de registro DNI "<DNI>", Nombre "<Nombre>", Apellidos "<Apellidos>", Contraseña "<Contraseña>"
     Then Recibo una respuesta Result "<Result>" DNI <"DNI">  de registro 
         And Borro usuario "<DNI>" Result "<Result>"

     Examples: 
      | DNI       | Nombre | Apellidos         | Contraseña    |Result  |
      | 04839751E |Antonio |  Rodríguez        |Antonio123     |OK      |
      | 1572672Q  |Antonio |    Pérez López    |PerezLopez123  |Error   |
      | 15726772Q |        | Pulido Hernández  |Jaimemanuel123 |Error   |      
      | 15726772Q |Jaime   |                   |Jaimemanuel123 |Error   |
      |           |Jaime   | Manuel Pérez      |Jaimemanuel123 |Error   |
      | 10572676  |Jaime   | Manuel Pérez      |Jaimemanuel123 |Error   |      
      |15726772Q  |Juan    | Prueba Prueba     | hola          |Error   |
      |15726772Q  |Juan    | Prueba Prueba     | holaaaaaaa    |Error   |
      |15726772Q  |Antonio | Pulido Hernández  | antonio123    |Error   |
      |15726772Q  | Juan   | Prueba Prueba     | Jaimemanuel123|Error   |
      |05726690N  |Antonio | Rodríguez         | Antonio123    |Error   |
      |15726772Q  |Antonio | Rodríguez         | Antonio123    |Error   |
      |00572676E  |Antonio | Rodríguez         | ANTONIO123    |Error   |
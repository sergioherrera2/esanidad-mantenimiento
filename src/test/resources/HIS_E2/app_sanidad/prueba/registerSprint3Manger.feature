@tag
Feature: Registro

  @tag1
  Scenario Outline: Como usuario quiero que el servidor me registre
    Given Un usuario con todos los campos de registro DNI "<DNI>", Nombre "<Nombre>", Apellidos "<Apellidos>", Contraseña "<Contraseña>"
    When se registra "<Result>"
    Then Se guarda correctamente el nuevo usuario "<DNI>" Result "<Result>"
    And Borro usuario "<DNI>" Result "<Result>"

    
     Examples: 
      | DNI       | Nombre | Apellidos         | Contraseña    |Result  |
      | 04839982T |Antonio | Pulido Hernández  |Antonio123     |OK      |
      | 1057267Z  |Antonio |    Pérez López    |PerezLopez123  |Error   |
      | 10572676J |        | Pulido Hernández  |Jaimemanuel123 |Error   |      
      | 10572676J |Jaime   |                   |Jaimemanuel123 |Error   |
      |           |Jaime   | Manuel Pérez      |Jaimemanuel123 |Error   |
      | 10572676  |Jaime   | Manuel Pérez      |Jaimemanuel123 |Error   |      
      |15726773V  |Juan    | Prueba Prueba     | hola          |Error   |
      |15726773V  |Juan    | Prueba Prueba     | holaaaaaaa    |Error   |
      |15726773V  |Antonio | Pulido Hernández  | antonio123    |Error   |
      |00572676E  | Juan   | Prueba Prueba     | Jaimemanuel123|Error   |
      |05726690N  |Antonio | Rodríguez         | Antonio123    |Error   |
      |05726690S  |Antonio | Rodríguez         | Antonio123    |Error   |
      |00572676E  |Antonio | Rodríguez         | ANTONIO123    |Error   |
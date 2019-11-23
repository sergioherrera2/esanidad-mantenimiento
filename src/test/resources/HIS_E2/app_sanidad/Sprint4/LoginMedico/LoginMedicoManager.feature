
@tag
Feature: Autenticacion de medico Manager

  @tag1
  Scenario Outline: Como medico quiero autenticarme
    Given Un usuario con dni "<dni>" y contrasenia "<contrasenia>"
    When me autentico como sanitaro "<Response>"
    Then si soy sanitario me autentico "<Response>"

    Examples: 
    | dni               | contrasenia     |Response  |
    | 98276278S         | Pedro123        | OK       |
    | 05726691          | hola            | Error    |
    | 98276278N         |                 | Error    |
    | 97637789Y         | Carlos12        | Error    |
    | 98276278N         |                 | Error    |
    | 98276278S         | Pedro123        | OK       |

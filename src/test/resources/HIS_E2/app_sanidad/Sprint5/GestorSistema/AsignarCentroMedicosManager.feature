
@tag
Feature: Asignar centros a médicos

  @tag1
  Scenario Outline: Como gestor del sistema, quiero asignar centros a médicos (Manager)
    Given tengo un centro su nombre "<centro>",localidad "<localidad>"
    And Tengo de un medico su dni "<dni>"
    When asigno el centro "<response>"
    Then el médico se ha guardado con dni "<dni>", centro "<centro>"

  Examples:
		| dni       | centro															| localidad		| response  |
		| 97637789Y | Ciudad Real III 									  | Ciudad Real	| OK        |
		| 97637789Y |              											  | Ciudad Real	| Error     |
		|           | Hospital General Ciudad Real    	  | 						| Error     |
		| 97637789Y | Hospital General Ciudad Real				| Ciudad Real	| OK	      |


@tag
Feature: Asignar centros a médicos

  @tag1
  Scenario Outline: Como gestor del sistema, quiero asignar centros a médicos (Manager)
    Given tengo un centro su nombre "<centro>",localidad "<localidad>"
    And Tengo de un medico su dni "<dni>"
    When asigno el centro "<response>"
    Then el médico se ha guardado con dni "<dni>", centro "<centro>", "<response>"

  Examples:
		| dni       | centro															| localidad		| response  |
		| 71360861A | Ciudad Real III 									  | Ciudad Real	| OK        |
		| 71360861A |              											  | Ciudad Real	| Error     |
		|           | Hospital General						    	  | 						| Error     |
		| 71360861A | Hospital General 										| 						| Error     |

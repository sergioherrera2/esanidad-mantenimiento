
@tag
Feature: Creación de una especialidad

  @tag1
  Scenario Outline: Como gestor del sistema quiero poder modificar especialidades a traves de una petición web
    Given ClienteHttpEspecialidad
    When Envio peticion modificar especialidad nombre "<nombre>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>",response "<response>"
    Then Recibo una respuesta de modificacion nombre "<nombre>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>",response "<response>"
     Then la especialidad ha sido modificada correctamente nombre"<nombre>",duracion"<duracion_mod>",hora inicio "<hora_inico_mod>",hora final "<hora_final_mod>",nueva duracion"<30>", response "<response>"

     
#  @tag2
#  Scenario: sistema
#    Given ClienteHttpEspecialidad
#   When Envio peticion modificar especialidad nombre"<Podología>",duracion"<15>",hora inicio "<9:00>",hora final "<14:00>",nueva duracion"<30>", response"<Error>"
#    Then Recibo una respuesta de modificacion nombre"<Podología>",duracion"<15>",hora inicio "<9:00>",hora final "<14:00>",nueva duracion"<30>", response"<Error>"
#     Then la especialidad ha sido modificada correctamente nombre"<Podología>",duracion"<15>",hora inicio "<9:00>",hora final "<14:00>",nueva duracion"<30>", response"<Error>"
 
 
Examples:
	|nombre         | duracion     |hora_inicio| hora_final        | duracion_mod     |hora_inicio_mod| hora_final_mod   |response             |
	| Podología     |   15         |  9:00     | 14:00             | 10               |10:00          | 15:00            | OK                  |
	| Podología     |   15         |  9:00     | 14:00             | -1               |9:00           | 14:00            | Error               |
	| Podología     |   15         |  9:00     | 14:00             | 0                |9:00           | 14:00            | Error               |
	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 8:00             | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
# | Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| Podología     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |





    
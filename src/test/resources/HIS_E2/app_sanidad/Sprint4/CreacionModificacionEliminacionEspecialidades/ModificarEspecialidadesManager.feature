
@tag
Feature: Creación de una especialidad

@tag1
Scenario Outline: Como gestor quiero poder modificar especialidades
Given Tengo nombre "<nombre>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>"
Given creo la especialidad "<response>"
Then La especialidad ha sido guardada nombre "<nombre>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<OK>"
When modifico la especialidad response "<response>"
Then la especialidad ha sido modificada correctamente nombre "<nombre>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>",response "<OK>"
Then borro la especialidad nombre "<nombre>",duracion "<duracion_mod>",hora inico "<hora_inicio_mod>",hora final "<hora_final_mod>",response "<response>"


#@tag2
#Scenario: Como gestor quiero poder modificar especialidades
#Given Tengo nombre "<Podología>",duracion "<15>",hora inicio "<9:00>",hora final "<14:00>"
#Given creo la especialidad "<response>"
#Then La especialidad ha sido guardada nombre "<Podología>",duracion "<1000>",hora inico "<9:00>",hora final "<14:00>",response "<OK>"
#When modifico la especialidad nombre"<Podología>",duracion"<15>",hora inicio "<9:00>",hora final "<14:00>",nueva duracion"<30>", response"<OK>"
#Then la especialidad ha sido modificada correctamente nombre"<Podología>",duracion"<15>",hora inicio "<9:00>",hora final "<14:00>",nueva duracion"<30>", response"<OK>"


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






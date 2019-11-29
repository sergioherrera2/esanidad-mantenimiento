
#@tag
#Feature: Modificacion de una especialidad
#
#  @tag1
#  Scenario Outline: Como gestor del sistema quiero poder crear especialidades
#    Given Tengo dni "<dni>",duracion "<duracion>",hora inicio "<hora_inicio>",hora final "<hora_final>",duracion_mod "<duracion_mod>", hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>"
#    Given Abroo Firefox y entro en la aplicacion citas
#    And Entro en la vista del gestor dni"<768766579C>" contraseña "<password>"
#    When Presiono el boton modificar especialidad y recibo respuesta "<response>"
#    Then relleno los campos de modificacion duracion_mod "<duracion_mod>",hora_inicio_mod "<hora_inicio_mod>", hora_final_mod "<hora_final_mod>"
#    Then La especialidad ha sido guardada dni "<dni>",duracion "<duracion_mod>",hora inico "<hora_inicio_mod>",hora final "<hora_final_mod>",response "<response>"
#    Then borro la especialidad dni "<dni>",duracion "<duracion_mod>",hora inico "<hora_inicio_mod>",hora final "<hora_final_mod>",response "<response>"
#    
#Examples:
#	|dni            | duracion     |hora_inicio| hora_final        | duracion_mod     |hora_inicio_mod| hora_final_mod   |response             |
#	| 05726279S     |   15         |  9:00     | 14:00             | 10               |10:00          | 15:00            | OK                  |
#	| 05726279S     |   15         |  9:00     | 14:00             | -1               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 0                |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 8:00             | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
# | 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |
#	| 05726279S     |   15         |  9:00     | 14:00             | 15               |9:00           | 14:00            | Error               |

#
#@tag
#Feature: Creación de una especialidad
#
#  @tag1
#  Scenario Outline: Como administrador quiero crear una especialidad (Vista)
#  
#  Given Abroo Firefox y entro en la aplicacion citas
#  And Entro en la vista del gestor dni"<768766579C>" contraseña "<password>"
#  When relleno los campos dni dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>"
#Then La especialidad ha sido guardada dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
#    Then borro la especialidad dni "<dni>",duracion "<duracion>",hora inico "<hora_inicio>",hora final "<hora_final>",response "<response>"
#    
#Examples:
#	|dni         | duracion     |hora_inicio| hora_final       |response             |
#	| 05726279S     |   15         |  9:00     | 14:00            | OK                  |
#	|               |   20         |  9:00     | 14:00            | Error               |
#	| 1234          |   20         |  9:00     |14:00             | Error               |
#	|E12            |   5          |  9:00     | 14:00            | Error               |
#	|05726279S       |   15         |  9:00     |14:00             | OK                  |
#	|05726279S       |   A          |  9:00     |14:00             | Error               |
#	|05726279S      |   0          |  9:00     |14:00             | Error               |
#	|05726279S      |              |  9:00     |14:00             | Error               |
#	|05726279S      |   -1         |  9:00     |14:00             | Error               |
#	| 05726279S     |   15         |  9:00     | 22:00            | Error               |
#	| 05726279S     |   15         |  22:00    | 4:00             | Error               |
#	| 05726279S     |   15         |  8:00     | 14:00            | Error               |

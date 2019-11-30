package HIS_E2.app_sanidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**Clase controller de la página de horario.
 * 
 */
@Controller
public class HorarioController {

    /**Controlador mapeo de la página de horario.
     * @return Devuelve el html de la página de horarios medico.
     */
    @RequestMapping(value = "/horario", method = RequestMethod.GET)
    public String getEspecialidad() {
      return "views/horario.html";
    }
}
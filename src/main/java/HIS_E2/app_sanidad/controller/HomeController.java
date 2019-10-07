package HIS_E2.app_sanidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**Clase controladora del index de la página.
 * @author Miguel
 */
@Controller
public class HomeController {
	/**Controla el mapeo de la página de incio.
	 * @return Devuelve el html del index.
	 */
	@RequestMapping("/home")
	public String home() {
		return "index.html";
	}

}

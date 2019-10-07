package HIS_E2.app_sanidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CitasController {

	@RequestMapping(value = "/citas", method = RequestMethod.GET)
	public String getCitas() {
		return "views/citas.html";
	}
}

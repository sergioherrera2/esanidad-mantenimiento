package HIS_E2.app_sanidad.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@RequestMapping("/getUser")
	public void getUserById(@PathVariable Integer userId) {
	}

	 @RequestMapping("/getAllUsers")
	 public void getAllUsers() {
	 }
	 
	 @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	 public void saveUser(@RequestBody String userDto) {
	 }
}

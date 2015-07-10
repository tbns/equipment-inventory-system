package pl.tbns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date May 8, 2015 1:50:43 PM
 * 
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String indexLogin(Model model) {
		return "login.index";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String indexAdmin(Model model) {
		return "admin.index";
	}

	public String index(Model model) {
		return "login.index";

	}
	
}

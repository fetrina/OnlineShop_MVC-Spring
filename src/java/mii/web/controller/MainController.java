//===== CONTROLLER utama yang mengatur Login User ======
package mii.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author user2
 */
@Controller
public class MainController {
     //========= SCRIPT untuk coba Spring-security =============
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public RedirectView adminPage() {
 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
		return new RedirectView("/admin/home", true);//ke controller yg mmliki value mapping /admin/home (yaitu di AdminController)
		//return model;
	}
    
    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("login");
		return model;
	}
//    //script default diatas dignti 2 bris bwh ini
//        public RedirectView welcomePage() {
//            return new RedirectView("spring_security_login", true); //klo kyk gini indexny jadi form login spring-scrty, tpi brhsl login cm skali pas prtm kli :(
//	}
        
        
    @RequestMapping(value = "/client**", method = RequestMethod.GET)
	public RedirectView clientPage() {
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected client page!");
//		model.setViewName("home_client"); //hlmn home.jsp
//		return model;
            return new RedirectView("/client/home", true);
        }

}

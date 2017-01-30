package mii.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user2
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping(value = "/home", method= RequestMethod.GET) // didalam value itu url yg kita panggil nantinya. ato jk ada ahref di jsp kita nulis value itu
    public String toHome(Model model){
        return "home"; //ini sesuai nama jspnya, misal home.jsp
    }
    
    @RequestMapping(value = "/category", method= RequestMethod.GET)
    public String toCategory(Model model){
        return "category"; 
    }
    
    @RequestMapping(value = "/buku", method= RequestMethod.GET)
    public String toBuku(Model model){
        return "buku"; 
    }
    
    @RequestMapping(value = "/customer", method= RequestMethod.GET)
    public String toCustomer(Model model){
        return "customer"; 
    }
    
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String toHomeAdmin(Model model){
        return "home"; 
    }
    
//    //========= SCRIPT untuk coba Spring-security =============
//    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("home"); //hlmn home.jsp
//		return model;
// 
//	}
//    
//    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is welcome page!");
//		model.setViewName("login");
//		return model;
// 
//	}    
}

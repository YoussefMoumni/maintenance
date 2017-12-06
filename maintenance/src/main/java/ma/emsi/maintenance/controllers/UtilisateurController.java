package ma.emsi.maintenance.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ma.emsi.maintenance.model.Utilisateur;
import ma.emsi.maintenance.services.UtilisateurService;

@Controller 
@RequestMapping("/") 
public class UtilisateurController {
	@Autowired
	UtilisateurService utilisateurService;
	
	
	@GetMapping("/users")
	@ResponseBody
	public List<Utilisateur> afficher() {
	return utilisateurService.getUtilisateurs(); 
	}
	
	
	
	@GetMapping("/")
	public String index(Model m) {
	return "authentification"; }
	
	 @RequestMapping("/login")  
	   public ModelAndView login(HttpServletRequest request,
			   HttpServletResponse response) {
		  String login=request.getParameter("login");  
	      String password=request.getParameter("password");
	      String message;
	    //  utilisateurservice.getUtilisateur()
	      if(
	    		  password != null && 
	    		  !password.equals("") && 
	    		  password.equals("123")){
	    	  message = "Welcome " +login + ".";
		      return new ModelAndView("hello", 
		    		  "message", message);  
	 
	      }else{
	    	  message = "Wrong username or password.";
	    	  return new ModelAndView("errorPage", 
	    			  "message", message);
	      }
	   }
	 
	 
	 
}

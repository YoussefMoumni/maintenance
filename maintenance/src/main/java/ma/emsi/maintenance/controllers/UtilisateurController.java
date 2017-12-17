package ma.emsi.maintenance.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ma.emsi.maintenance.model.Utilisateur;
import ma.emsi.maintenance.services.UtilisateurService;

@Controller 
@RequestMapping("/") 
@CrossOrigin(origins = "http://localhost:8888")
public class UtilisateurController {
	@Autowired
	UtilisateurService utilisateurService;
	
	@GetMapping("/")
	public String index(Model m) {
	return "authentification"; }
	
	@GetMapping("/users")
	@ResponseBody
	public List<Utilisateur> affichertouts() {
	return utilisateurService.getUtilisateurs(); 
	}
	
	@GetMapping("/user")
	@ResponseBody
	public Utilisateur afficherun(int id) {
	return utilisateurService.getUtilisateur(id); 
	}
	
	
	 @RequestMapping("/getIdByLogin")
	  @ResponseBody
	  public int getIdByLogin(String login) {
	    int Id;
	    try {
	      Utilisateur U = utilisateurService.getUtilisateurByLogin(login);
	     Id =  U.getIdUtilisateur();
	    }
	    catch (Exception ex) {
	      return 0 ;
	    }
	    return Id;
	   
	  }
	
	
	 @RequestMapping("/login")  
	   public ModelAndView login(HttpServletRequest request,
			   HttpServletResponse response) {
		  String login=request.getParameter("login");  
	      String password=request.getParameter("password");
	      
	     
	      
	      String message;
	    //  utilisateurservice.getUtilisateur()
	      if(   	     	  
	    		  login != null && !login.equals("") && 
	    		  password != null && !password.equals(""))
	    		      {
	    			  if( getIdByLogin(login)>0) { ///////// Si l'utilisateur avec le login definie existe
	    				Utilisateur U= utilisateurService.getUtilisateur(getIdByLogin(login));
	    				      if(password.equals(U.getMdp())) {  ////////// Si  Mot de passe correcte
	    				      	  message = "Welcome " +login + ".";
	    					      return new ModelAndView("hello", 
	    					    		  "message", message);  
	    				            } else{
	    				  	    	  message = "Faux mot de passe.";
	    					    	  return new ModelAndView("errorPage", 
	    					    			  "message", message);
	    					      }
	    			              
	    			  }   else{
	    		    	  message = "Aucun Utilisateur pour cet login";
	    		    	  return new ModelAndView("errorPage", 
	    		    			  "message", message);
	    		      }
	    		  
	    		     }
	      else{
	    	  message = "Wrong username or password.";
	    	  return new ModelAndView("errorPage", 
	    			  "message", message);
	      }
	     
	   
	      
	     
	   }
	
	 }
	 


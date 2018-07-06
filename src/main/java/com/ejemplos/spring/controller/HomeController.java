package com.ejemplos.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//siempre para que inserte objeto automaticamente
	@Autowired
	private UserService userService;
	
	//para que se use nada mas empezar
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
    	System.out.println("class = HomeController  -- RequestMapping = / --  method = handleRequest -- inicio");
		List<User> listUsers = userService.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
    	System.out.println("class = HomeController  -- RequestMapping = / --  method = handleRequest -- fin");
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
    	System.out.println("class = HomeController  -- RequestMapping = /new --  method = newUser -- inicio");
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new User());
    	System.out.println("class = HomeController  -- RequestMapping = /new --  method = newUser -- fin");
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
    	System.out.println("class = HomeController  -- RequestMapping = /edit --  method = editUser -- inicio");
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
    	System.out.println("class = HomeController  -- RequestMapping = /edit --  method = editUser -- fin");
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
    	System.out.println("class = HomeController  -- RequestMapping = /delete --  method = deleteUser -- inicio");
		int userId = Integer.parseInt(request.getParameter("id"));
		userService.delete(userId);
		//esto para redirigir al controlador ya que si llamo a userlist.jsp petaria o saldria vacio
    	System.out.println("class = HomeController  -- RequestMapping = /delete --  method = deleteUser -- fin");
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
    	System.out.println("class = HomeController  -- RequestMapping = /save --  method = saveUser -- inicio");
		userService.saveOrUpdate(user);
    	System.out.println("class = HomeController  -- RequestMapping = /save --  method = saveUser -- fin");
		return new ModelAndView("redirect:/");
	}
	
}

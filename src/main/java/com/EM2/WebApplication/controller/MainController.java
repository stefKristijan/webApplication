package com.EM2.WebApplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EM2.WebApplication.model.User;
import com.EM2.WebApplication.service.EmployeeService;
import com.EM2.WebApplication.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value= {"/","/login"})
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping(value= "/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView("registration");
		User user = new User();
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	
	@PostMapping("/registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if(userExists!=null) {
			bindingResult.rejectValue("email", "error.user","There is already a user registered with this e-mail!");
		}
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		}else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage","User has been registered successfully!");
			modelAndView.addObject("user",new User());
		}
		return modelAndView;
	}
	
	@GetMapping("/admin/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

}

package com.spring.boot.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.domain.User;
import com.spring.boot.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		User user1 = userService.login(user.getUsername(), user.getPassword());
		System.out.print(user1);
		if(Objects.nonNull(user1)) {
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}
}

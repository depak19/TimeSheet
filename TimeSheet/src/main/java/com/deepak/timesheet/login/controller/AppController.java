package com.deepak.timesheet.login.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deepak.timesheet.login.model.User;
import com.deepak.timesheet.login.model.UserProfile;
import com.deepak.timesheet.login.service.UserProfileService;
import com.deepak.timesheet.login.service.UserService;
import com.deepak.timesheet.util.StringUtils;

@Controller
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;
	@Autowired
	UserProfileService userProfileService;
	@Autowired
	MessageSource messageSource;

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/registration.do" }, method = RequestMethod.POST)
	public String saveRegistration(@Valid User user, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "registration";
		}
		userService.save(user);
		model.addAttribute("success", "User " + user.getFirstName() + " "
				+ user.getLastName() + " registered successfully");
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/registration.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String newRegistration(ModelMap model,
			@RequestParam(value = "ssoid", required = false) String ssoid) {
		User user = new User();
		if (StringUtils.notNullOrBlank(ssoid)) {
			user = userService.findBySso(ssoid);
			model.addAttribute("edit", true);
		}
		model.addAttribute("user", user);
		return "registration";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

}

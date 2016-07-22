package com.deepak.timesheet.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deepak.timesheet.login.model.User;
import com.deepak.timesheet.login.model.UserProfile;
import com.deepak.timesheet.login.service.UserProfileService;
import com.deepak.timesheet.login.service.UserService;
import com.deepak.timesheet.util.StringUtils;

@Controller
@SessionAttributes("roles")
public class UserController {
	static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = { "/userLanding.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String welcomePage() {
		return "secured/user/userLanding";
	}

	@RequestMapping(value = { "/userProfile.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String userProfile(ModelMap model) {
		return "secured/user/userProfile";
	}

	@RequestMapping(value = { "/userDetails.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String newRegistration(ModelMap model,
			@RequestParam(value = "ssoid", required = false) String ssoid) {
		User user = new User();
		if (StringUtils.notNullOrBlank(ssoid)) {
			user = userService.findBySso(ssoid);
			model.addAttribute("edit", true);
		}
		model.addAttribute("user", user);
		return "secured/user/userDetails";
	}

	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
}

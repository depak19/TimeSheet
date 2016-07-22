package com.deepak.timesheet.login.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = { "/logoutPage" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String logoutPage() {
		return "loginPage";
	}

	@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String defaultPage() {
		return "redirect:/userLanding.do";
	}

	@RequestMapping(value = { "/loginPage.do" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String loginPage() {
		return "loginPage";
	}

}

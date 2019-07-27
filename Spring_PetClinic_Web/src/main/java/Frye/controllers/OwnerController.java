package Frye.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Frye.services.OwnerService;

@Controller
public class OwnerController {

	OwnerService os;

	public OwnerController(OwnerService os) {
		super();
		this.os = os;
	}

	@RequestMapping({ "/owners", "/owners/index", "owners/index.html" })
	public String listOwners(Model model) {

		model.addAttribute("Owner", os.findAll());

		return "owners/index";
	}

	@RequestMapping({"/owners/find", "/oups"})
	public String findOwners() {

		return "notWorking";
	}
}

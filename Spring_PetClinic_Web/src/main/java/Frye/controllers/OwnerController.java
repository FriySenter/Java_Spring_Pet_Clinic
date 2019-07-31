package Frye.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Frye.services.OwnerService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OwnerController {

    private final OwnerService os;

    public OwnerController(OwnerService os) {
        super();
        this.os = os;
    }

    @InitBinder
    public void NotAllowFieds(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("Owner", os.findAll());

        return "owners/index";
    }

    @RequestMapping({"/owners/find", "/oups"})
    public String findOwners() {

        return "notWorking";
    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(os.findById(ownerId));
        return mav;
    }
}

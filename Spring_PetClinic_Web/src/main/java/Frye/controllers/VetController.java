package Frye.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import Frye.models.Vet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Frye.services.VetService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VetController {

    VetService vs;

    public VetController(VetService vs) {
        super();
        this.vs = vs;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("Vets", vs.findAll());

        return "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
       	return vs.findAll();
    }

}

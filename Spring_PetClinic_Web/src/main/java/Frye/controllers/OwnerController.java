package Frye.controllers;

import Frye.models.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import Frye.services.OwnerService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OwnerController {


    private static final String VIEW_OWNER_CREATED_OR_UPDATED = "owners/createOrUpdateOwnerForm";
    private final OwnerService os;

    public OwnerController(OwnerService os) {
        super();
        this.os = os;
    }

    @InitBinder
    public void NotAllowFieds(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

//    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
//    public String listOwners(Model model) {
//
//        model.addAttribute("Owner", os.findAll());
//
//        return "owners/index";
//    }

    @RequestMapping({"/owners/find", "/oups"})
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm(Owner owner, BindingResult result, Model model) {

        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = os.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results == null) {
            result.rejectValue("lastName", "notFound", "notFound!");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(os.findById(ownerId));
        return mav;
    }

    @GetMapping("owners/new")
    public String initCreateForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());

        return VIEW_OWNER_CREATED_OR_UPDATED;
    }

    @PostMapping("owners/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEW_OWNER_CREATED_OR_UPDATED;
        } else {
            Owner savedOwner = os.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/owners/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model){
        model.addAttribute(os.findById(ownerId));
        return VIEW_OWNER_CREATED_OR_UPDATED;
    }

    @PostMapping("/owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId){
        if(result.hasErrors()){
            return VIEW_OWNER_CREATED_OR_UPDATED;
        }else{
            owner.setId(ownerId);
            Owner savedOwner = os.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}

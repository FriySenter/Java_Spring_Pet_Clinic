package Frye.controllers;

import Frye.models.Owner;
import Frye.models.Pet;
import Frye.models.PetType;
import Frye.services.OwnerService;
import Frye.services.PetServices;
import Frye.services.PetTypeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("owners/{ownerId}")
public class PetController {

    private static final String VIEW_PETS_CREATED_OR_UPDATED = "pets/createOrUpdatePetForm";
    private final PetServices ps;
    private final OwnerService os;
    private final PetTypeService pts;

    public PetController(PetServices ps, OwnerService os, PetTypeService pts) {
        this.ps = ps;
        this.os = os;
        this.pts = pts;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return pts.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return os.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEW_PETS_CREATED_OR_UPDATED;
    }

    @PostMapping("pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "alreadyExist");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEW_PETS_CREATED_OR_UPDATED;
        } else {
            ps.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", ps.findById(petId));
        return VIEW_PETS_CREATED_OR_UPDATED;
    }

    @PostMapping("pets/{petId}/edit")
    public String processUpdatedForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEW_PETS_CREATED_OR_UPDATED;
        } else {
            owner.getPets().add(pet);
            ps.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}

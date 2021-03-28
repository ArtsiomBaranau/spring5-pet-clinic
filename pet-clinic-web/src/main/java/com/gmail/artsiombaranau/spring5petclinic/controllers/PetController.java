package com.gmail.artsiombaranau.spring5petclinic.controllers;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import com.gmail.artsiombaranau.spring5petclinic.model.PetType;
import com.gmail.artsiombaranau.spring5petclinic.services.OwnerService;
import com.gmail.artsiombaranau.spring5petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owner/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetTypeService petTypeService, OwnerService ownerService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
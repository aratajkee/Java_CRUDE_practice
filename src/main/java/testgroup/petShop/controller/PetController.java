package testgroup.petShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testgroup.petShop.model.Pet;
import testgroup.petShop.services.PetService;

import java.util.List;

@Controller
public class PetController {

    PetService petService;
    @Autowired
    private void setPetService(PetService petService){
        this.petService = petService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allPets(){
        List<Pet> allPets = petService.allPets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pets");
        modelAndView.addObject("petList", allPets);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable ("id") int id){
        Pet pet = petService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("pet", pet);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPet(@ModelAttribute("pet") Pet pet){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        petService.edit(pet);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addPet(@ModelAttribute("pet") Pet pet){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        petService.add(pet);
        return modelAndView;

    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    public ModelAndView deletePet(@ModelAttribute("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        petService.delete(petService.getById(id));
        return modelAndView;
    }



}

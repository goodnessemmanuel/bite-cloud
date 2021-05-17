package com.ocheejeh.bitecloud.controller;

import com.ocheejeh.bitecloud.bootstrap.BiteCloudBootstrapData;
import com.ocheejeh.bitecloud.model.Bite;
import com.ocheejeh.bitecloud.model.Ingredient;
import com.ocheejeh.bitecloud.model.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignBiteController {

    @Autowired
    public DesignBiteController() {
    }

    @GetMapping
    public String showBiteDesignForm(Model model){
        List<Ingredient> ingredients = List.of(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        Map<String, List<Ingredient>> typeIngredientMap = new HashMap<>();

        for (Ingredient.Type type: types) {
            List<Ingredient> ingredientList = ingredients.stream()
                    .filter(ingredient -> type.equals(ingredient.getType()))
                    .collect(Collectors.toList());
            //typeIngredientMap.put(type.toString().toLowerCase(), ingredientList);
            model.addAttribute(type.toString().toLowerCase(), ingredientList);
        }
        //model.addAllAttributes(typeIngredientMap);
        model.addAttribute("bite", new Bite());
        return "bite";
    }

    @PostMapping
    public String processDesign(@Valid Bite bite, final Errors errors){
        if(errors.hasErrors()){
            return "bite";
        }
        log.info("Designing your bite " +  bite);

        return "redirect:/orders/current";
    }

}

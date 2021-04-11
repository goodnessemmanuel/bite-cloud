package com.ocheejeh.bitecloud.controller;

import com.ocheejeh.bitecloud.model.Bite;
import com.ocheejeh.bitecloud.model.Ingredient;
import com.ocheejeh.bitecloud.model.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignBiteController {

    @GetMapping
    public String showBiteDesignForm(Model model){
        List<Ingredient> ingredients = List.of(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        Map<String, List<Ingredient>> typeIngredientMap = new HashMap<>();

        for (Type type: types) {
            List<Ingredient> ingredientList = ingredients.stream()
                    .filter(ingredient -> type.equals(ingredient.getType()))
                    .collect(Collectors.toList());
            typeIngredientMap.put(type.toString().toLowerCase(), ingredientList);
        }
        model.addAllAttributes(typeIngredientMap);
        model.addAttribute("design", new Bite());
        return "bite";
    }

    @PostMapping
    public String processDesign(Bite bite){
        log.info("Designing your bite " +  bite);

        return "redirect:/orders/current";
    }
}

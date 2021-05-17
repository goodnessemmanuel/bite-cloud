package com.ocheejeh.bitecloud.bootstrap;

import com.ocheejeh.bitecloud.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BiteCloudBootstrapData {
    public Map<String, List<Ingredient>> loadData(){
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
            typeIngredientMap.put(type.toString().toLowerCase(), ingredientList);
        }
        return typeIngredientMap;
    }
}

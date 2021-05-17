package com.ocheejeh.bitecloud.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class Bite {
    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull(message = "You should ingredients at least")
    @Size(min = 1, message = "Must have at least 1 bite ingredient")
    private List<String> ingredients = new ArrayList<>();

    public void addIngredient(String string){
        ingredients.add(string);
    }

}

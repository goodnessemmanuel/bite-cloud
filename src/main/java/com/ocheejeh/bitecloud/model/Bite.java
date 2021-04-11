package com.ocheejeh.bitecloud.model;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Bite {
    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "Must have at least 1 bite ingredient")
    List<String> ingredients;

}

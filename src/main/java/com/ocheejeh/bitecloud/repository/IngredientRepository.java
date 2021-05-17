package com.ocheejeh.bitecloud.repository;

import com.ocheejeh.bitecloud.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}

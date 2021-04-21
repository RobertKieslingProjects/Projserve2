package com.group3.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group3.springrest.models.Ingredients;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, String> {
	List<Ingredients> findByIngredientName(String ingredientName);
}

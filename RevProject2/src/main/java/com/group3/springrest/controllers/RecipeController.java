package com.group3.springrest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.springrest.exceptions.ResourceNotFoundException;
import com.group3.springrest.models.Recipes;
import com.group3.springrest.repository.RecipeRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/r1")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	//http://localhost:9095/api/u1/recipes
	@GetMapping("/recipes")
	public List<Recipes> getAllRecipes() {
		return recipeRepository.findAll();
	}
	
	@PostMapping("/recipes")
	public Recipes createUser(@Valid @RequestBody Recipes recipe) {
		return recipeRepository.save(recipe);
	}
	
	@GetMapping("/recipes/{recipe_id}")
	public ResponseEntity<Recipes> getRecipeById(@PathVariable(value = "recipe_id") long recipeId)
	throws ResourceNotFoundException {
		Recipes recipe = recipeRepository.findById(recipeId)
		.orElseThrow(() -> new ResourceNotFoundException ("Recipe not found for this id :: " + recipeId));
	return ResponseEntity.ok().body(recipe);
	}

	@PutMapping("/recipes/{recipe_id}")
	public ResponseEntity<Recipes> updateRecipe(@PathVariable(value = "recipe_id") long recipeId,
											@Valid @RequestBody Recipes recipeDetails) throws ResourceNotFoundException {
		Recipes recipe = recipeRepository.findById(recipeId)
		.orElseThrow(() -> new ResourceNotFoundException ("Recipe not found for this id :: " + recipeId));
		
		recipe.setRecipeName(recipeDetails.getRecipeName());
		recipe.setSkillLevel(recipeDetails.getSkillLevel());
		final Recipes updateRecipe = recipeRepository.save(recipe);
		return ResponseEntity.ok(updateRecipe);
		
	}
}

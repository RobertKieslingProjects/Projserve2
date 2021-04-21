package com.group3.springrest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipes {
	
	private long recipeId;
	private String recipeName;
	private String skillLevel;

	public Recipes() {
		
	}
	
	public Recipes(long recipeId, String recipeName, String skillLevel) {
		this.recipeId = recipeId; 
		this.recipeName = recipeName;
		this.skillLevel = skillLevel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	@Column(name = "recipe_name", nullable = false)
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	@Column(name = "skill_level", nullable = false)
	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	
}

package com.group3.springrest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredients {
	
	private long ingredientId;
	private String amount;
	private String ingredientName;
	private long recipeId;
	
	public Ingredients() {
		
	}
	
	public Ingredients(long ingredientId, String ingredientName, String amount, int recipeId) {
		this.ingredientId = ingredientId; 
		this.ingredientName = ingredientName;
		this.amount = amount;
		this.recipeId = recipeId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(long ingredientId) {
		this.ingredientId = ingredientId;
	}

	@Column(name = "ingredient_name", nullable = false)
	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	@Column(name = "amount", nullable = false)
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "recipe_Id", nullable = false)
	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}
	
}

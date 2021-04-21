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
import com.group3.springrest.models.Favorites;
import com.group3.springrest.repository.FavoritesRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/f1")
public class FavoritesController {
	
	@Autowired
	private FavoritesRepository favoritesRepository;
	
	//http://localhost:9095/api/f1/favorites
	@GetMapping("/favorites")
	public List<Favorites> getAllFavorites() {
		return favoritesRepository.findAll();
	}
	
	@PostMapping("/addfavorites")
	public Favorites addFavorite(@Valid @RequestBody Favorites favorite) {
		return favoritesRepository.save(favorite);
	}

	@GetMapping("/favorites/{user_id}")
	public ResponseEntity<Favorites> getFavoritesByUserId(@PathVariable(value = "user_id") long userId)
	throws ResourceNotFoundException {
		Favorites favorite = favoritesRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException ("Favorite not found for this id :: " + userId));
	return ResponseEntity.ok().body(favorite);
	}
	
	@PutMapping("/favorites/{user_id}")
	public ResponseEntity<Favorites> updateFavorites(@PathVariable(value = "user_id") long userId,
											@Valid @RequestBody Favorites favoritesDetails) throws ResourceNotFoundException {
		Favorites favorite = favoritesRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException ("Favorite not found for this id :: " + userId));
		
		favorite.setRecipeId(favoritesDetails.getRecipeId());
		final Favorites updateFavorites = favoritesRepository.save(favorite);
		return ResponseEntity.ok(updateFavorites);
		
	}
}

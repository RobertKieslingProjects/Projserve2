package com.group3.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.Logger;

import com.group3.springrest.models.Recipes;

@Repository
public interface RecipeRepository extends JpaRepository<Recipes, Long>{
    public static 
}

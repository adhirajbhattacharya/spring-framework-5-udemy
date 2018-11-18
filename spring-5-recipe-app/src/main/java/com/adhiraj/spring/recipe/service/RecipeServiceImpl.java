package com.adhiraj.spring.recipe.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adhiraj.spring.recipe.domain.Recipe;
import com.adhiraj.spring.recipe.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  @Autowired
  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    super();
    this.recipeRepository = recipeRepository;
  }

  public Set<Recipe> getRecipes() {
    Set<Recipe> recipes = new HashSet<>();
    recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
    return recipes;
  }

}

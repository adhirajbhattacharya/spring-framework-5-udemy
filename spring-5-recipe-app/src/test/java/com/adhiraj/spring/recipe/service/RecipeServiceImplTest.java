package com.adhiraj.spring.recipe.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.adhiraj.spring.recipe.domain.Recipe;
import com.adhiraj.spring.recipe.repository.RecipeRepository;

public class RecipeServiceImplTest {

  private RecipeServiceImpl recipeService;

  @Mock
  private RecipeRepository recipeRepository;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.recipeService = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  public void getRecipes() throws Exception {
    Recipe recipeDummy = new Recipe();
    Set<Recipe> recipeDummySet = new HashSet<>();
    recipeDummySet.add(recipeDummy);

    when(recipeService.getRecipes()).thenReturn(recipeDummySet);

    Set<Recipe> recipes = recipeService.getRecipes();
    assertEquals(1, recipes.size());

    verify(recipeRepository, times(1)).findAll();
  }

}

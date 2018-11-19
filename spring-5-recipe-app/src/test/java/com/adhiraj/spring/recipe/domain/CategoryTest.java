package com.adhiraj.spring.recipe.domain;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

  private final Long dummyId = 4L;
  private final String dummyDescription = "description";
  private final Recipe dummyRecipe = new Recipe();
  private final Set<Recipe> dummyRecipeSet = new HashSet<>();
  private Category category;

  @Before
  public void setUp() {
    this.category = new Category();
  }

  @Test
  public void getId() throws Exception {
    this.category.setId(dummyId);

    assertEquals(dummyId, this.category.getId());
  }

  @Test
  public void getDescription() throws Exception {
    this.category.setDescription(dummyDescription);

    assertEquals(dummyDescription, this.category.getDescription());
  }

  @Test
  public void getRecipes() throws Exception {
    dummyRecipeSet.add(dummyRecipe);
    this.category.setRecipes(dummyRecipeSet);

    assertEquals(dummyRecipeSet, this.category.getRecipes());
  }

}

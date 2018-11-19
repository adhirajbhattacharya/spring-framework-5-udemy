package com.adhiraj.spring.recipe.controller;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import com.adhiraj.spring.recipe.domain.Recipe;
import com.adhiraj.spring.recipe.service.RecipeService;

public class IndexControllerTest {

  private String getIndexReturn = "index";

  private IndexController indexController;

  @Mock
  private RecipeService recipeService;

  @Mock
  private Model model;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    this.indexController = new IndexController(recipeService);
  }

  @Test
  public void testMockMvc() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name(getIndexReturn));
  }

  @Test
  public void getIndex() throws Exception {

    // given
    Recipe recipeDummy = new Recipe();
    Set<Recipe> recipeDummySet = new HashSet<>();
    recipeDummySet.add(recipeDummy);

    Mockito.when(recipeService.getRecipes()).thenReturn(recipeDummySet);

    ArgumentCaptor<Set<Recipe>> recipesCaptor = ArgumentCaptor.forClass(Set.class);

    // when
    String viewName = indexController.getIndex(model);

    // then
    Assert.assertEquals(getIndexReturn, viewName);

    Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"),
        recipesCaptor.capture());
    Assert.assertEquals(recipeDummySet, recipesCaptor.getValue());
    Assert.assertEquals(recipeDummySet.size(), recipesCaptor.getValue().size());

    Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
  }

}

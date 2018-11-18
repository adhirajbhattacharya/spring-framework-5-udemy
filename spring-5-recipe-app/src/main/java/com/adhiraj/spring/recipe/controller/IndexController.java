package com.adhiraj.spring.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adhiraj.spring.recipe.service.RecipeService;

@Controller
@RequestMapping("")
public class IndexController {

  private final RecipeService recipeService;

  @Autowired
  public IndexController(RecipeService recipeService) {
    super();
    this.recipeService = recipeService;
  }

  @RequestMapping({"", "/index", "/index.html"})
  public String getIndex(Model model) {
    model.addAttribute("recipes", recipeService.getRecipes());
    return "index";
  }

}

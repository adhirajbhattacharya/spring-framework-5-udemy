package com.adhiraj.spring.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

  @RequestMapping({"", "/index", "/index.html"})
  public String getIndex() {
    return "index";
  }

}

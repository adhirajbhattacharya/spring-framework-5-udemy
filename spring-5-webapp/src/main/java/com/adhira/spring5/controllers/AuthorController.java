package com.adhira.spring5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.adhira.spring5.repositories.AuthorRepository;

@Controller
public class AuthorController {

  private AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    super();
    this.authorRepository = authorRepository;
  }
  
  @GetMapping("/authors")
  public String getAuthors(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }
  
}

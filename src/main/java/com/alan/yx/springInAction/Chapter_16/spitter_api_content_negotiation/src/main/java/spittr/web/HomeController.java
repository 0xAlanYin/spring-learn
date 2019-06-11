package com.alan.yx.springInAction.Chapter_16.spitter_api_content_negotiation.src.main.java.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {
 
  @RequestMapping(method = GET)
  public String home(Model model) {
    return "home";
  }

}

package br.com.tarek.your.business.war.controllers;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tarek on 08/12/15.
 */
public interface HomeController {
  ModelAndView homePage();

  ModelAndView helpPage();

  ModelAndView aboutPage();
}

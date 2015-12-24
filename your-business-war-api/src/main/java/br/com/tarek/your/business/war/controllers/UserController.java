package br.com.tarek.your.business.war.controllers;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tarek on 24/12/15.
 */
public interface UserController {
  ModelAndView users();

  ModelAndView newUser();
}

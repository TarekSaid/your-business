package br.com.tarek.your.business.controllers;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tarek on 24/12/15.
 */
public interface BusinessController {
  ModelAndView businesses();

  ModelAndView newBusiness();
}

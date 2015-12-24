package br.com.tarek.your.business.war.controllers.impl;

import br.com.tarek.your.business.war.controllers.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tarek on 24/12/15.
 */
@Controller
public class UserControllerImpl implements UserController {

  @Override
  @RequestMapping(value = "users/", method = RequestMethod.GET)
  public ModelAndView users() {
    return new ModelAndView("users/list");
  }

  @Override
  @RequestMapping(value = "signup", method = RequestMethod.GET)
  public ModelAndView newUser() {
    return new ModelAndView("users/new");
  }
}

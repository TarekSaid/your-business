package br.com.tarek.your.business.war.controllers.impl;

import br.com.tarek.your.business.war.controllers.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tarek on 08/12/15.
 */
@Controller
public class HomeControllerImpl implements HomeController {

  @Override
  @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
  public ModelAndView homePage() {
    return new ModelAndView("home");
  }

  @Override
  @RequestMapping(value = "/help", method = RequestMethod.GET)
  public ModelAndView helpPage() {
    return new ModelAndView("help");
  }
}

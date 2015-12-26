package br.com.tarek.your.business.controllers.impl;

import br.com.tarek.your.business.controllers.BusinessController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tarek on 24/12/15.
 */
@Controller
public class BusinessControllerImpl implements BusinessController {

  @Override
  @RequestMapping(value = "/businesses", method = RequestMethod.GET)
  public ModelAndView businesses() {
    return new ModelAndView("businesses/list");
  }

  @Override
  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public ModelAndView newBusiness() {
    return new ModelAndView("businesses/new");
  }
}

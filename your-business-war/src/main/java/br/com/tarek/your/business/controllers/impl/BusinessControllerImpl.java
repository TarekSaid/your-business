package br.com.tarek.your.business.controllers.impl;

import br.com.tarek.your.business.controllers.BusinessController;
import br.com.tarek.your.business.models.Business;
import br.com.tarek.your.business.services.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by tarek on 24/12/15.
 */
@Controller
public class BusinessControllerImpl implements BusinessController {

  @Inject
  private BusinessService businessService;

  @Override
  @RequestMapping(value = "/businesses", method = RequestMethod.GET)
  public ModelAndView businesses() {
    return new ModelAndView("businesses/list");
  }

  @Override
  @RequestMapping(value = "/business/{id}", method = RequestMethod.GET)
  public ModelAndView show(@PathVariable Long id) {
    Business business = businessService.findBusiness(id);

    return new ModelAndView("businesses/show", "business", business);
  }

  @Override
  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public ModelAndView newBusiness() {
    return new ModelAndView("businesses/new");
  }
}

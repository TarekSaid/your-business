package br.com.tarek.your.business.controllers.impl;

import br.com.tarek.your.business.models.Business;
import br.com.tarek.your.business.services.BusinessService;
import mockit.*;
import org.assertj.core.data.MapEntry;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 24/12/15.
 */
@Test
public class BusinessControllerImplTest {

  @Tested
  private BusinessControllerImpl businessController;

  @Injectable
  private BusinessService businessService;

  public void businessesShouldReturnListView() {
    assertThat(businessController.businesses()).isNotNull();
    assertThat(businessController.businesses().getViewName()).isEqualTo("businesses/list");
  }


  public void showShouldCallFindBusinessFromBusinessService() {
    businessController.show(1L);

    new Verifications() {{
      businessService.findBusiness(1L);
    }};
  }

  public void showShouldPopulateModelAndView(@Mocked Business business) {
    new Expectations() {{
      businessService.findBusiness(1L); result = business;
    }};

    ModelAndView view = businessController.show(1L);

    assertThat(view).isNotNull();
    assertThat(view.getViewName()).isEqualTo("businesses/show");
    assertThat(view.getModel()).containsEntry("business", business);
  }

  public void newBusinessShouldReturnNewView() {
    assertThat(businessController.newBusiness()).isNotNull();
    assertThat(businessController.newBusiness().getViewName()).isEqualTo("businesses/new");
  }
}

package br.com.tarek.your.business.war.controllers.impl;

import mockit.Tested;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 24/12/15.
 */
@Test
public class BusinessControllerImplTest {

  @Tested
  private BusinessControllerImpl userController;

  public void usersShouldReturnUsersView() {
    assertThat(userController.businesses()).isNotNull();
    assertThat(userController.businesses().getViewName()).isEqualTo("businesses/list");
  }

  public void newUserShouldReturnNewView() {
    assertThat(userController.newBusiness()).isNotNull();
    assertThat(userController.newBusiness().getViewName()).isEqualTo("businesses/new");
  }
}

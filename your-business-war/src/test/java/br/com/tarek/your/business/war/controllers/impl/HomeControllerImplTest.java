package br.com.tarek.your.business.war.controllers.impl;

import mockit.Tested;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 19/12/15.
 */
@Test
public class HomeControllerImplTest {

  @Tested
  private HomeControllerImpl homeController;

  public void homePageShouldReturnHomeView() {
    assertThat(homeController.homePage()).isNotNull();
    assertThat(homeController.homePage().getViewName()).isEqualTo("home");
  }

  public void helpPageShouldReturnHelpView() {
    assertThat(homeController.helpPage()).isNotNull();
    assertThat(homeController.helpPage().getViewName()).isEqualTo("help");
  }

  public void aboutPageShouldReturnAboutView() {
    assertThat(homeController.aboutPage()).isNotNull();
    assertThat(homeController.aboutPage().getViewName()).isEqualTo("about");
  }
}

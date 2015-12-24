package br.com.tarek.your.business.war.controllers.impl;

import mockit.Tested;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 24/12/15.
 */
@Test
public class UserControllerImplTest {

  @Tested
  private UserControllerImpl userController;

  public void usersShouldReturnUsersView() {
    assertThat(userController.users()).isNotNull();
    assertThat(userController.users().getViewName()).isEqualTo("list");
  }

  public void newUserShouldReturnNewView() {
    assertThat(userController.newUser()).isNotNull();
    assertThat(userController.newUser().getViewName()).isEqualTo("new");
  }
}

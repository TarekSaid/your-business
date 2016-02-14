package br.com.tarek.your.business.models;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 26/12/15.
 */
public class BusinessTest {

  public static final String NOT_BLANK_MSG = "{org.hibernate.validator.constraints.NotBlank.message}";
  public static final String LENGTH_MSG = "{javax.validation.constraints.Size.message}";
  public static final String PATTERN_MSG = "{javax.validation.constraints.Pattern.message}";

  private Validator validator;

  @DataProvider(name = "blankFields")
  public Iterator<Object[]> blankFields() {
    return Arrays.asList(new Object[]{null}, new Object[]{""}, new Object[]{"         "}).iterator();
  }

  @DataProvider(name = "validEmails")
  public Iterator<Object[]> validEmails() {
    return Arrays.asList(new Object[]{"user@example.com"}, new Object[]{"USER@foo.COM"},
        new Object[]{"A_US-ER@foo.bar.org"}, new Object[]{"first.last@foo.jp"}, new Object[]{"alice+bob@baz.cn"},
        new Object[]{"tarek.said.info@gmail.com"}, new Object[]{"leticia.mgoncalves@hotmail.com"})
        .iterator();
  }

  @DataProvider(name = "invalidEmails")
  public Iterator<Object[]> invalidEmails() {
    return Arrays.asList(new Object[]{"test"}, new Object[]{"blah@foo"}, new Object[]{"hello@"},
        new Object[]{"user@example,com"}, new Object[]{"user_at_foo.org"}, new Object[]{"user.name@example."},
        new Object[]{"foo@bar_baz.com"}, new Object[]{"foo@bar+baz.com"}, new Object[]{"foo@bar..com"}).iterator();
  }

  @BeforeMethod
  public void createValidator() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  /**
   * Checks if business is validating blank names.
   *
   * @param name provided by the dataProvider.
   */
  @Test(dataProvider = "blankFields")
  public void nameShouldNotBeBlank(String name) {
    assertThat(validator.validateValue(Business.class, "name", name))
        .hasSize(1)
        .extracting(v -> v.getMessageTemplate())
        .containsOnly(NOT_BLANK_MSG);
  }

  @Test
  public void nameShouldHaveNoMoreThan50Characters() {
    assertThat(validator.validateValue(Business.class, "name", StringUtils.repeat("s", 51)))
        .hasSize(1)
        .extracting(v -> v.getMessageTemplate())
        .containsOnly(LENGTH_MSG);
  }

  /**
   * Checks if business is validating null email.
   */
  @Test(dataProvider = "blankFields")
  public void emailShouldNotBeBlank(String email) {
    assertThat(validator.validateValue(Business.class, "email", email))
        .extracting(v -> v.getMessageTemplate())
        .contains(NOT_BLANK_MSG);
  }

  @Test
  public void emailShouldHaveNoMoreThan255Characters() {
    assertThat(validator.validateValue(Business.class, "email", StringUtils.repeat("a", 244) + "@example.com.br"))
        .hasSize(1)
        .extracting(v -> v.getMessageTemplate())
        .containsOnly(LENGTH_MSG);
  }

  @Test(dataProvider = "validEmails")
  public void thisEmailShouldBeValid(String email) {
    assertThat(validator.validateValue(Business.class, "email", email))
        .isEmpty();
  }

  @Test(dataProvider = "invalidEmails")
  public void thisEmailShouldBeInvalid(String email) {
    assertThat(validator.validateValue(Business.class, "email", email))
        .hasSize(1)
        .extracting(v -> v.getMessageTemplate())
        .containsOnly(PATTERN_MSG);
  }

  @Test(dataProvider = "blankFields")
  public void passwordShouldNotBeBlank(String password) {
    assertThat(validator.validateValue(Business.class, "password", password))
        .hasSize(1)
        .extracting(v -> v.getMessageTemplate())
        .containsOnly(NOT_BLANK_MSG);
  }

  @Test
  public void passwordShouldHaveNoMoreThan60Characters() {
    assertThat(validator.validateValue(Business.class, "password", StringUtils.repeat("a", 61)))
        .hasSize(1)
        .extracting(v -> v.getMessageTemplate())
        .containsOnly(LENGTH_MSG);
  }
}

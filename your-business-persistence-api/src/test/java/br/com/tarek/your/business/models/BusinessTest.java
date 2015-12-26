package br.com.tarek.your.business.models;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 26/12/15.
 */
@Test
public class BusinessTest {

  public static final String NOT_NULL = "{javax.validation.constraints.NotNull.message}";
  private Validator validator;

  @BeforeMethod
  public void createValidator() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  /**
   * Checks if business is validating null name
   */
  public void businessShouldValidateNameNotNull() {
    assertThat(validator.validateValue(Business.class, "name", null))
        .hasSize(1)
        .extracting(v -> tuple(v.getPropertyPath().toString(), v.getMessageTemplate()))
        .containsOnly(tuple("name", NOT_NULL));
  }

  /**
   * Checks if business is validating null email
   */
  public void businessShouldValidateEmailNotNull() {
    assertThat(validator.validateValue(Business.class, "email", null))
        .hasSize(1)
        .extracting(v -> tuple(v.getPropertyPath().toString(), v.getMessageTemplate()))
        .containsOnly(tuple("email", NOT_NULL));
  }
}

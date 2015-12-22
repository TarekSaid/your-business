package br.com.tarek.your.business.war.integration.homepage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by tarek on 19/12/15.
 */
@StepDefAnnotation
public class HomepageSteps {

  private WebDriver driver;

  @Given("^that I am using Firefox$")
  public void that_I_am_using_Firefox() {
    driver = new HtmlUnitDriver();
  }

  @When("^I open the (.*) page$")
  public void I_open_the_page(String view) {
    driver.get("http://localhost:8080/your-business/" + view);
  }

  @Then("^the title should be \"([^\"]*)\"$")
  public void the_title_should_be(String title) {
    assertThat(driver.getTitle()).isEqualTo(title);
  }

  @Then("^I should see (\\d) links? to the (.*) page$")
  public void I_should_see_links_to_the_page(int number, String view) {
    List<WebElement> elements = driver.findElements(By.cssSelector("a[href*='" + view + "']"));

    assertThat(elements).hasSize(number);
  }
}

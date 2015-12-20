package br.com.tarek.your.business.war.integration.homepage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

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

  @Then("^the page title should be \"([^\"]*)\"$")
  public void the_page_title_should_be(String pageTitle) {
    WebElement element = driver.findElement(By.xpath("//html/body/div/h1"));
    assertThat(element.getText()).isEqualTo(pageTitle);
  }
}

package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class loginStepDefs {
    WebDriver driver=null;
    public final static String GECKO_DRIVER_LOCATION = "geckodriver";

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp()
    {
        driver.close();
    }

    @Given("^firefox browser is open$")
    public void firefox_browser_is_open() throws Throwable {
        System.out.println("step1");
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("inside Step - user is on login page");
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
      driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("click on login button")
    public void click_on_login_button() {
        System.out.println("inside Step - browser is open");
        driver.findElement(By.id("login")).click();

    }
    @Then("user navigated to the home page")
    public void user_navigated_to_the_home_page() {
        System.out.println("inside Step - browser is open");
        driver.findElement(By.id("greetings"));
        driver.close();
    }
}

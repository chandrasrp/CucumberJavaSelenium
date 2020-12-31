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

import java.util.concurrent.TimeUnit;

public class googleSearchStepDefs {
    WebDriver driver=null;
    public final static String CHROME_DRIVER_LOCATION = "chromedriver";

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

    @Given("^browser is open$")
    public void browser_is_open() throws Throwable {
        System.out.println("step1");
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

    }

    @And("^user is on google search page$")
    public void user_is_on_google_search_page() throws Throwable {
        System.out.println("step2");
        driver.navigate().to("https://google.com");
    }

    @When("^user enters a text in search box$")
    public void user_enters_a_text_in_search_box() throws Throwable {
        System.out.println("step3");
        driver.findElement(By.name("q")).sendKeys("india");
    }

    @And("^hits enter$")
    public void hits_enter() throws Throwable {
        System.out.println("step4");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("^user navigated to search results$")
    public void user_navigated_to_search_results() throws Throwable {
        System.out.println("step5");
        driver.getPageSource().contains("Ram Nath Kovind");

        driver.close();
        driver.quit();
    }


}

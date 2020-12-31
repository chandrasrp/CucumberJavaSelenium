package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class qaTest {
    WebDriver driver = null;
    public final static String GECKO_DRIVER_LOCATION = "geckodriver";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp() {
        driver.close();
    }

    @Given("^user is on dg homepage$")
    public void user_is_on_dg_homepage() {
        System.out.println("step1");
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to("https://davies-group.com/");

    }

    @And("^hoverover on About to select location$")
    public void hoverover_on_about_to_select_location() {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.id("menu-item-18261"));
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'About' from Menu");
    }

    @And("^click on location$")
    public void click_on_location() {
        driver.findElement(By.xpath("(//a[contains(text(),'Locations')])[5]")).click();
        //Actions actions = new Actions(driver);
        // WebElement subMenuOption = driver.findElement(By.cssSelector("Locations"));
        //Mouse hover menuOption 'Location'
        // actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on 'Locations' from Menu");
    }

    @And("^maps page is opened$")
    public void maps_page_is_opened() throws InterruptedException {
        System.out.println("Maps page opened");
        Thread.sleep(4000);
    }

    @When("^click on stoke address point$")
    public void click_on_stoke_address_point() throws InterruptedException {
        driver.findElement(By.id("marker0_12")).click();
        Thread.sleep(4000);
    }

    @Then("^Stoke address is captured")
    public void stoke_address_is_captured() throws InterruptedException {
        driver.findElement(By.xpath("//section[@id='svgContainer0']/ul")).click();
        Thread.sleep(4000);
        // driver.findElement(By.xpath("1"));
        String stoke_on_trent_address = driver.findElement(By.xpath("//p[contains(text(),'3rd and 4th Floors, No.2 Smithfields, Stoke-on-Tre')]")).getText();
        System.out.println(stoke_on_trent_address);
        driver.close();
    }

}

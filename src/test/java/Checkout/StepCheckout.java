package Checkout;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepCheckout {

    WebDriver driver;

    @Given("^Open the chrome and launch SauceDemo website$")
    public void Open_the_chrome_and_launch_SauceDemo_website() throws Throwable {
//        System.out.println("This is step user open the chrome and launch SauceDemo website");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    @When("^Entered Username Password and Click Login$")
    public void  Entered_Username_Password_and_Click_Login() throws Throwable {
//        System.out.println("This is step user entered Username, Password, and Click Login");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
    }

    @And("^User selects Backpack product to add to cart$")
    public void User_selects_Backpack_product_to_add_to_cart() throws Throwable {
//        System.out.println("This is step user selects Backpack for ordered");
        String urlRedirect = driver.getCurrentUrl();
        String urlExpected = "https://www.saucedemo.com/inventory.html";
        System.out.println("URL nya "+urlRedirect);
        Assert.assertEquals(urlRedirect, urlExpected);
        Thread.sleep(2000);
        WebElement titleProducts = driver.findElement(By.className("title"));
        titleProducts.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        WebElement ShoppingCart1 = driver.findElement(By.className("shopping_cart_badge"));
        ShoppingCart1.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
        String url_Redirect = driver.getCurrentUrl();
        String url_Expected = "https://www.saucedemo.com/cart.html";
        System.out.println("URL Your Cart "+url_Redirect);
        Assert.assertEquals(url_Redirect, url_Expected);
        WebElement titleYourCart = driver.findElement(By.className("title"));
        titleYourCart.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
    }

    @And("^User entered information data$")
    public void User_entered_information_data() throws Throwable {
//        System.out.println("User entered First Name, Last Name, and Postal Code");
        String urlStepOne = driver.getCurrentUrl();
        String urlStepOne_expected = "https://www.saucedemo.com/checkout-step-one.html";
        System.out.println("URL Step One "+urlStepOne);
        Assert.assertEquals(urlStepOne, urlStepOne_expected);
        WebElement titleInformation = driver.findElement(By.className("title"));
        titleInformation.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.id("first-name")).sendKeys("Indra");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("Purnomo");
        Thread.sleep(2000);
        driver.findElement(By.id("postal-code")).sendKeys("11420");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        String urlStepTwo = driver.getCurrentUrl();
        String urlStepTwo_expected = "https://www.saucedemo.com/checkout-step-two.html";
        System.out.println("URL Step Two "+urlStepTwo);
        Assert.assertEquals(urlStepTwo, urlStepTwo_expected);
        WebElement titleOverview = driver.findElement(By.className("title"));
        titleOverview.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
    }

    @Then("^User successfully and complete order Backpack$")
    public void User_successfully_and_complete_order_Backpack() throws Throwable {
//        System.out.println("This is step user successfully and complete order Backpack");
        String urlComplete = driver.getCurrentUrl();
        String urlComplete_expected = "https://www.saucedemo.com/checkout-complete.html";
        System.out.println("URL Complete order "+urlComplete);
        Assert.assertEquals(urlComplete, urlComplete_expected);
        WebElement titleComplete = driver.findElement(By.className("title"));
        titleComplete.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
        Thread.sleep(2000);
        WebElement ThankYouForYourOrder = driver.findElement(By.className("complete-header"));
        ThankYouForYourOrder.isDisplayed();
        Assert.assertTrue(driver.findElement(By.className("complete-header")).isDisplayed());
    }
}

# Investree - Indra Purnomo

## Installation

Selenium may be installed via npm with

`npm install selenium-webdriver`

You will need to download additional components to work with each of the major browsers.

| Browser           | Component                                                                                                                                        |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ |
| Chrome            | [chromedriver(.exe)](http://chromedriver.storage.googleapis.com/index.html)                                                                      |
| Internet Explorer | [IEDriverServer.exe](https://www.selenium.dev/downloads/)                                                                                        |
| Edge              | [MicrosoftWebDriver.msi](https://www.bing.com/?ref=go&linkid=619687)                                                                             |
| Firefox           | [geckodriver(.exe)](https://github.com/mozilla/geckodriver/releases/)                                                                            |    
| Opera             | [operadriver(.exe)](https://github.com/operasoftware/operachromiumdriver/releases)                                                               |
| Safari            | [safaridriver](https://developer.apple.com/library/archive/releasenotes/General/WhatsNewInSafari/Articles/Safari_10_0.html#//apple_ref/doc/uid/TP40014305-CH11-DontLinkElementID_28) |


## Scenario

In this scenario, user want to buy Bacpack in DemoSauce site:

```java
Feature: Shop for Backpack on the SauceDemo website

  Scenario: User successfully shopping Backpack in the SauceDemo website
    Given Open the chrome and launch SauceDemo site
    When Entered Username Password and Click button Login
    And User selects Backpack product to add to cart in SauceDemo site
    And User entered information data in SauceDemo site
    Then User successfully and complete order Backpack in SauceDemo site
    
    Feature: Search by keyword

  Scenario: Searching for a term
    Given Sergey is researching things on the internet
    When he looks up "Cucumber"
    Then he should see information about "Cucumber"
```

## Step definition

This is step user open the chrome and launch SauceDemo website:

```java
public class StepCheckout {

    WebDriver driver;

    @Given("Open the chrome and launch SauceDemo site")
    public void openTheChromeAndLaunchSauceDemoSite() throws Throwable {
//        System.out.println("This is step user open the chrome and launch SauceDemo website");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }
```    
This is step user entered Username, Password, and Click Login:

```java
   
   @When("Entered Username Password and Click button Login")
   public void enteredUsernamePasswordAndClickButtonLogin() throws Throwable {
//        System.out.println("This is step user entered Username, Password, and Click Login");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
    }
```
This is step user selects Backpack for ordered:

```java
    @And("User selects Backpack product to add to cart in SauceDemo site")
    public void userSelectsBackpackProductToAddToCartInSauceDemoSite() throws Throwable {
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
```
User entered First Name, Last Name, and Postal Code:

```java
    @And("User entered information data in SauceDemo site")
    public void userEnteredInformationDataInSauceDemoSite() throws Throwable {
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
```
This is step user successfully and complete order Backpack:

```java
    @Then("User successfully and complete order Backpack in SauceDemo site")
    public void userSuccessfullyAndCompleteOrderBackpackInSauceDemoSite() throws Throwable {
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

```

## Executing the tests

- Clone this repository with command git clone `https://github.com/Indrapurnomo29/Investree-IndraPurnomo.git`

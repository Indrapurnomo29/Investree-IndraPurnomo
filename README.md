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

You also need to install a plugin Cucumber for Java and Gherkin and add dependency at pom.xml as below:

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>Investree-IndraPurnomo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>3.141.59</version>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-server</artifactId>
            <version>3.141.59</version>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.3.4</version>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.3.4</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
            <version>7.3.4</version>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>gherkin</artifactId>
            <version>23.0.1</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.0</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.masterthought</groupId>
                <artifactId>maven-cucumber-reporting</artifactId>
                <version>2.8.0</version>
                <executions>
                    <execution>
                        <id>execution</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <projectName>automation-bdd-google</projectName>
                            <outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
                            <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
```

## Scenario

In this scenario, user want to buy Bacpack in DemoSauce site. You can create feature class as below:

```java
    Feature: Shop for Backpack on the SauceDemo website

  Scenario: User successfully shopping Backpack in the SauceDemo website
    Given Open the chrome and launch SauceDemo site
    When Entered Username Password and Click button Login
    And User selects Backpack product to add to cart in SauceDemo site
    And User entered information data in SauceDemo site
    Then User successfully and complete order Backpack in SauceDemo site
```

## Step definition

Here's a Java code step with @Given, @When, @And, @And, @Then as below:

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
        driver.close();
        driver.quit();
    }
}

```

## Executing the tests

To run this project, you can just run test with the feature class as below:

![run-scenario](https://user-images.githubusercontent.com/65549993/187221590-c1dc5e3d-5671-4ea1-afa1-223112b2cc69.jpg)

## Report

- Create java class "TestRunner" in Directory TestRunner and you can use this code by copy as below:

```java
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/checkout",
        glue = "Checkout",
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml",
                "pretty","json:target/cucumber.json"})
public class Checkout {
}
```
- Open a terminal on Intellij, then type `mvn test`, it will be automatic running test and result as below:

![mvn-test](https://user-images.githubusercontent.com/65549993/187225531-1d704cd1-5c56-40b9-bdb7-f5ccb992a4ae.jpg)
![mvn-test-1](https://user-images.githubusercontent.com/65549993/187225601-76ed3ba7-cbd5-4f9b-8b3b-c0de5dbff9bb.jpg)

- And type `mvn verify -DskipTests` for generate test report as below:

![mvn-verify](https://user-images.githubusercontent.com/65549993/187225806-b5ac7d36-4e91-4999-9994-f57c7ccfb192.jpg)

- Open directory target and open this file with Open In -> Browser -> Chrome as below:

![target](https://user-images.githubusercontent.com/65549993/187229374-68ce778b-19bc-417e-bdfd-0e667ef9197f.jpg)

- Then you will get the results of the report as below:

![result-report](https://user-images.githubusercontent.com/65549993/187229524-033d14ae-8966-48d0-b31a-7eaa12e48da8.jpg)

## Thank you






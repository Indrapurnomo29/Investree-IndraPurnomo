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

In this scenario, user want to Bacpack in DemoSauce site:

```java
Feature: Shop for Backpack on the SauceDemo website

  Scenario: User successfully shopping Backpack in the SauceDemo website
    Given Open the chrome and launch SauceDemo site
    When Entered Username Password and Click button Login
    And User selects Backpack product to add to cart in SauceDemo site
    And User entered information data in SauceDemo site
    Then User successfully and complete order Backpack in SauceDemo site
```

- Clone this repository with command git clone `https://github.com/Indrapurnomo29/Investree-IndraPurnomo.git`

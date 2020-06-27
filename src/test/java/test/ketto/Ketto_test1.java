package test.ketto;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ketto.Config_class;
import pages.ketto.FundRaiserForm;
import pages.ketto.Home_Page;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;

public class Ketto_test1 {
    String userdir = System.getProperty("user.dir");

    Config_class config_class = new Config_class();
    Properties prop = config_class.configClass();
    public String baseUrl = prop.getProperty("url");
    String driverPath = userdir+"//drivers//geckodriver-v0.26.0-win64//geckodriver.exe";
    String chromeDriverPath = userdir+"//drivers//chromedriver_win32//chromedriver.exe";
    String ieDriverPath = userdir+"//drivers//IEDriverServer_x64_3.150.1//IEDriverServer.exe";
    public WebDriver driver;
    Home_Page home_page;
    FundRaiserForm fundRaiserForm;


    @Parameters("BrowserName")
    @BeforeTest
    public void setup(String browser){
        /*System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        home_page = new Home_Page(driver);*/

        System.out.println("Browser Name is: "+browser);

        if(browser.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();

        }

        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", ieDriverPath);
            driver = new InternetExplorerDriver();
        }



        driver.manage().window().maximize();
        driver.get(baseUrl);
        home_page = new Home_Page(driver);
        fundRaiserForm = new FundRaiserForm(driver);

    }

    @Test(priority = 0)
    public void verifyHomepageTitle() {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        home_page.StartFundRaiser();
    }

    @Test(priority = 1)
    public void verifyForm() throws InterruptedException {
        System.out.println("TEST 2");
        fundRaiserForm.FormValidation();
        Thread.sleep(3000);
    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
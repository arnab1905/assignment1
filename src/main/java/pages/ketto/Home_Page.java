package pages.ketto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page {

    WebDriver driver;
    public Home_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebElement ready;

    @FindBy(css = ".start-a-fundraiser > span:nth-child(1)")
    WebElement StartFundRaiserButton;
    @FindBy(xpath = "/html/body/app-root/div/app-sac-signup/div/app-card-view/mat-card/mat-card-header")
    WebElement StartFundRaiserFormTitle;

    public void StartFundRaiser(){
        System.out.println(StartFundRaiserButton.getText());
        StartFundRaiserButton.click();
        WebDriverWait wait = new WebDriverWait(driver,300);
        ready = wait.until(ExpectedConditions.visibilityOf(StartFundRaiserFormTitle));
        Assert.assertEquals(StartFundRaiserFormTitle.getText(),"Start your fundraiser");

        System.out.println("DONE!");
    }
}

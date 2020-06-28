package pages.ketto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.XMLFormatter;

public class FundRaiserForm<abc> {

    WebDriver driver;
    public FundRaiserForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebElement ready;
    Config_class config_class = new Config_class();
    Properties prop = config_class.configClass();

    @FindBy(xpath = "/html/body/app-root/div/app-sac-signup/div/app-card-view/mat-card/mat-card-content/form/app-sac-purpose/div/mat-form-field/div/div[1]/div/mat-select/div/div[2]/div")
    WebElement Select_arrow;

    @FindBy(xpath = "//*[@id=\"mat-option-25\"]")
    WebElement Med_Treat;

    @FindBy(xpath = "//*[@id=\"mat-option-26\"]")
    WebElement NGO_Char;

    @FindBy(xpath = "//*[@id=\"mat-option-27\"]")
    WebElement Other;

    ArrayList<WebElement> purposes1 = new ArrayList<WebElement>();

    //Textboxes
    @FindBy(xpath = "//*[@id=\"mat-input-3\"]")
    WebElement Name_TextBox;
    @FindBy(css = "#mat-hint-0 > em:nth-child(1)")
    WebElement Name_Guideline;
    @FindBy(xpath = "//*[@id=\"mat-input-4\"]")
    WebElement Mobile_TextBox;
    @FindBy(xpath = "//*[@id=\"mat-input-5\"]")
    WebElement Email_TextBox;
    @FindBy(xpath = "//*[@id=\"mat-input-6\"]")
    WebElement Password_TextBox;



    //Next Button
    @FindBy(css = ".button-wrapper")
    WebElement Next_button;

    //Step 1
    @FindBy(xpath = "/html/body/app-root/div/app-main/div/app-card-view/mat-card/app-basic/mat-card-header/div/mat-card-title")
    WebElement Step1_title;

    //Field Validations: Not working because of Captcha. Cross check xpath
    /*@FindBy(xpath = "//*[@id=\"mat-error-0\"]")
    WebElement Name_error1;
    @FindBy(xpath = "//*[@id=\"mat-error-8\"]")
    WebElement Name_error2;
    @FindBy(xpath = "//*[@id=\"mat-error-1\"]")
    WebElement Mobile_error1;
    @FindBy(xpath = "//*[@id=\"mat-error-9\"]")
    WebElement Mobile_error2;
    @FindBy(xpath = "//*[@id=\"mat-error-2\"]")
    WebElement Email_error1;
    @FindBy(xpath = "//*[@id=\"mat-error-10\"]")
    WebElement Email_error2;
    @FindBy(xpath = "//*[@id=\"mat-error-3\"]")
    WebElement Password_error1;
    @FindBy(xpath = "//*[@id=\"mat-error-12\"]")
    WebElement Password_error2;*/




    public void FormValidation() throws InterruptedException {
        Select_arrow.click();

        Thread.sleep(1500);
        Assert.assertEquals(Med_Treat.getText(),prop.getProperty("Med"));
        Assert.assertEquals(NGO_Char.getText(),prop.getProperty("NGO"));
        Assert.assertEquals(Other.getText(),prop.getProperty("Other_Cause"));

        // Add values in the purpose in the arraylist declared
        purposes1.add(Med_Treat);
        purposes1.add(NGO_Char);
        purposes1.add(Other);
        //System.out.println(purposes1); // Print the Purposes

        //Randomly select a Purpose
        Random rand = new Random();
        WebElement final_p = purposes1.get(rand.nextInt(purposes1.size()));
        System.out.println("Selected Purpose: "+final_p.getText());
        final_p.click();
        Assert.assertEquals(Name_Guideline.getText(),prop.getProperty("Name_Guideline"));
        Name_TextBox.sendKeys(prop.getProperty("Name"));
        Mobile_TextBox.sendKeys(prop.getProperty("Mobile"));
        Email_TextBox.sendKeys(prop.getProperty("EmailId"));
        Password_TextBox.sendKeys(prop.getProperty("Password"));

        Next_button.click();

        /*
        WebDriverWait wait = new WebDriverWait(driver,300);
        WebElement ready = wait.until(ExpectedConditions.visibilityOf(Step1_title));
        Assert.assertEquals(Step1_title.getText().toLowerCase(),"tell us more about your fundraiser");*/
        //CAPTCHA ISSUE....!!






        /*Assert.assertEquals(Name_error1.getText(),"Field Required");
        Assert.assertEquals(Mobile_error1.getText().toLowerCase(),"please enter a valid number");
        Assert.assertEquals(Email_error1.getText(),"Field Required");
        Assert.assertEquals(Password_error1.getText(),"Field Required");*/
        // On checking field validation, a captcha window is getting opened
    }
}
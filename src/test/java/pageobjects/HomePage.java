package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static common.Driver.driver;

/**
 * Created by Muneer on 19/06/2017.
 */
public class HomePage {

    @FindBy(how = How.XPATH, using = "//*[@id='container']/div[2]/div[3]")
    private WebElement LatestNewsSection;

    @FindBy(how = How.XPATH, using = ".//*[@id='navigationMenuWrapper']/descendant::span[text()='About']")
    private WebElement AboutPageLink;

    @FindBy(how = How.XPATH, using = ".//*[@id='navigationMenuWrapper']/descendant::span[text()='Work']")
    private WebElement WorkPageLink;

    @FindBy(how = How.XPATH, using = ".//*[@id='navigationMenuWrapper']/descendant::span[text()='Services']")
    private WebElement ServicesPageLink;

    @FindBy(how = How.LINK_TEXT, using = "contactcities li a")
    private WebElement ContactOffices;


    public HomePage() {

        PageFactory.initElements(driver, this);
    }
     public void navigateToHomePage(){
        driver.get("https://www.valtech.com/");
         WebElement dynamicElement =
                 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(AboutPageLink));
     }
    public boolean isLatestNewsSectionDisplayed() {
        WebElement dynamicElement =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(LatestNewsSection));
        if ((dynamicElement.isDisplayed())) {

            return true;

        } else {
            return false;
        }

    }


    public String getH1Title(String link) throws InterruptedException {
       System.out.println("Link name is " + link);
       String h1 ;
        if (link.equalsIgnoreCase("About")) {
            AboutPageLink.click();
            }
            if (link.equalsIgnoreCase( "Work") ){
                WorkPageLink.click();
            }
                 if (link.equalsIgnoreCase("Services")){
                ServicesPageLink.click();
            }
                 Thread.sleep(5000);
                 h1 = driver.findElement(By.tagName("h1")).getText();
                 return h1;
    }

    public void displayNumberOfContactOffices(){

        List<WebElement> numberOfOffices = driver.findElements(By.cssSelector("#container>section div ul  li"));
        System.out.println("Number Of Valtech Offices :" + numberOfOffices.size());
    }
}

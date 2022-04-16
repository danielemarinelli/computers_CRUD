package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage extends TestBase {

    @FindBy(xpath =".//a[@id='add']")
    private WebElement add;

    @FindBy(xpath ="(.//tbody/tr)[1]/td/a")
    private WebElement firstComputerOfTable;

    @FindBy(xpath ="(.//tbody/tr)[8]/td/a")
    private WebElement eightComputerOfTable;

    private WebDriver driver;
    public InitialPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String checkWebApplicationTitle()  {return driver.getTitle();}

    public void clickAddComputerButton(){add.click();}

    public void selectFirstComputer(){firstComputerOfTable.click();}

    public void selectEightComputer(){eightComputerOfTable.click();}
}

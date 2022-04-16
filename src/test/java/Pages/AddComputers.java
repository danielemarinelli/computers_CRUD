package Pages;

import Tests.TestBase;
import core.ExcelDataComputersInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddComputers extends TestBase {

    @FindBy(xpath =".//h1[text()='Add a computer']")
    private WebElement textDisplayed;

    @FindBy(xpath =".//input[@id='name']")
    private WebElement computerName;

    @FindBy(xpath =".//input[@id='introduced']")
    private WebElement introducedDate;

    @FindBy(xpath =".//select[@id='company']")
    private WebElement dropDown;

    @FindBy(xpath =".//input[@type='submit']")
    private WebElement createBtn;

    @FindBy(xpath =".//div[@class='alert-message warning']")
    private WebElement createdMsg;

    @FindBy(xpath ="(.//span[@class='help-inline'])[1]")
    private WebElement failureMsg;

    @FindBy(xpath ="(.//span[@class='help-inline'])[2]")
    private WebElement failureDateMsg;


    List<Map<String,String>> allDataFromFile;
    private WebDriver driver;
    public AddComputers(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void checkTitleDisplayed(){System.out.println(textDisplayed.getText());}

    public String insertRequiredFields() throws IOException {
        allDataFromFile = ExcelDataComputersInfo.getTestDataFromComputersInfoFile();
        System.out.println("....Inserting required fields....");
        computerName.sendKeys(allDataFromFile.get(0).get("CreateComputerName"));
        //computerName.sendKeys("ASUS 234 test");
        introducedDate.sendKeys("2022-04-16");
        Select opt = new Select(dropDown);
        opt.selectByVisibleText("Nokia");
        createBtn.click();
        System.out.println(createdMsg.getText());
        String[] computerCreation = createdMsg.getText().split(" ");
        return computerCreation[0];
    }

    public String addingWithoutNameComputerFieldPopulated(){
        createBtn.click();
        String[] computerCreationFailed = failureMsg.getText().split(" ");
        return computerCreationFailed[0];
    }

    public String updateComputerWithWrongFormatDate() throws IOException {
        List<Map<String,String>> allDataFromFile;
        allDataFromFile = ExcelDataComputersInfo.getTestDataFromComputersInfoFile();
        System.out.println("updating computer with wrong date....");
        computerName.click();
        computerName.clear();
        introducedDate.sendKeys(allDataFromFile.get(0).get("AlphanumericIntroducedDate"));
        createBtn.click();
        System.out.println(failureDateMsg.getText());
        String[] computerCreation = failureDateMsg.getText().split(" ");
        return computerCreation[0];

    }

}

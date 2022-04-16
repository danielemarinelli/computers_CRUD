package Pages;

import Tests.TestBase;
import core.ExcelDataComputersInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EditComputers extends TestBase {

    @FindBy(xpath =".//input[@class='btn danger']")
    private WebElement deleteBtn;

    @FindBy(xpath =".//div[@class='alert-message warning']")
    private WebElement msg;

    @FindBy(xpath =".//input[@id='name']")
    private WebElement computerName;

    @FindBy(xpath =".//input[@class='btn primary']")
    private WebElement saveComputerName;


    private WebDriver driver;
    public EditComputers(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void clickDeleteComputerButton(){deleteBtn.click();}

    public Boolean deleteComputer(){
        System.out.println("deleting computer....");
        System.out.println(msg.getText());
        return msg.getText().contains("deleted");
    }

    public Boolean updateComputer() throws IOException {
        List<Map<String,String>> allDataFromFile;
        allDataFromFile = ExcelDataComputersInfo.getTestDataFromComputersInfoFile();
        System.out.println("updating computer....");
        computerName.click();
        computerName.clear();
        //computerName.sendKeys("ASCI Purple TEST");
        computerName.sendKeys(allDataFromFile.get(0).get("CreateComputerName"));
        saveComputerName.click();
        System.out.println(msg.getText());
        return msg.getText().contains("updated");
    }


}

package Tests;

import Pages.AddComputers;
import Pages.EditComputers;
import Pages.InitialPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RunTestSuite extends TestBase{

    InitialPage initPage;
    AddComputers computers;
    EditComputers ec;

    @Test(priority=1,description="This test checks the initial web page")
    public void checkInitialPage()  {
        initPage = new InitialPage(driver());
        System.out.println("Title page:::: " + initPage.checkWebApplicationTitle());
        Assert.assertEquals(initPage.checkWebApplicationTitle(),"Computers database",
               "The initial webpage is wrong");
    }

    @Test(priority=2,description="This test adds a computer")
    public void addComputer() throws IOException {
        computers = new AddComputers(driver());
        initPage = new InitialPage(driver());
        initPage.clickAddComputerButton();
        computers.checkTitleDisplayed();
        String creation = computers.insertRequiredFields();
        Assert.assertEquals(creation,"Done",
                "The computer creation failed");
    }

    @Test(priority=3,description="This test checks the required name field is populated")
    public void checkMandatoryFieldsArePopulated()  {
        initPage = new InitialPage(driver());
        initPage.clickAddComputerButton();
        computers.checkTitleDisplayed();
        String error = computers.addingWithoutNameComputerFieldPopulated();
        Assert.assertEquals(error,"Failed",
                "The computer creation didn't fail - check and fix it");
    }

    @Test(priority=4,description="This test deletes the first computer created from the list")
    public void deleteComputer()  {
        initPage = new InitialPage(driver());
        initPage.selectFirstComputer();
        ec = new EditComputers(driver());
        ec.clickDeleteComputerButton();
        Boolean del = ec.deleteComputer();
        Assert.assertTrue(del);
    }

    @Test(priority=5,description="This test updates the eight computer created from the list")
    public void updateComputer() throws IOException {
        initPage = new InitialPage(driver());
        initPage.selectEightComputer();
        ec = new EditComputers(driver());
        //ec.updateComputer();
        Boolean u = ec.updateComputer();
        Assert.assertTrue(u);
    }

    @Test(priority=6,description="This test checks the required name field is populated\"")
    public void checkCorrectFormatDateField() throws IOException {
        initPage = new InitialPage(driver());
        initPage.clickAddComputerButton();
        computers = new AddComputers(driver());
        String fail = computers.updateComputerWithWrongFormatDate();
        Assert.assertEquals(fail,"Failed");
    }

}

package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private WebDriver driver = null;

    public WebDriver getDriver(String browser) {
        switch(browser.toLowerCase()) {
            case "chrome"  :
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge" :
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "ie" :
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default :
                System.out.println("Incorrect browser name provided "+ browser);
                System.out.println("Hence running in Chrome ");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);  // One time config done for the whole project
        driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS); // One time config
        return driver;
    }

    public void quitDriver() {
        if(driver!=null) {
            driver.quit();
        }
    }
}
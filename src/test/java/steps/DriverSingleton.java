package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver webDriver;

    private DriverSingleton(){}

    public static WebDriver getInstance(){
        if(webDriver == null){
            System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }

    public static void quitInstance(){
        if(webDriver != null){
            webDriver.quit();
            webDriver = null;
        }

    }
}

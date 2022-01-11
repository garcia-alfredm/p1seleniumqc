package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPom {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @FindBy(id = "username-input")
    WebElement usernameInput;

    @FindBy(id = "password-input")
    WebElement passwordInput;

    @FindBy(tagName = "button")
    WebElement loginButton;

    public LoginPom(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        PageFactory.initElements(this.webDriver, this);
    }

    public String getCurrentUrl(){
        return this.webDriver.getCurrentUrl();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

    public void waitForPath(String path){
        webDriverWait.until(ExpectedConditions.urlToBe("http://localhost:7000/" + path));
    }

    public void waitForElements(){
        webDriverWait.until(ExpectedConditions.visibilityOf(usernameInput));
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordInput));
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}

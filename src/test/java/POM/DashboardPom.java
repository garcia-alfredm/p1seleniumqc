package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.X11.XSystemTrayPeer;

import java.time.Duration;
import java.util.List;

public class DashboardPom {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @FindBy(className = "approve")
    List<WebElement>  approveButtons;

    @FindBy(className = "deny")
    List<WebElement> denyButtons;

    int buttonCount = -1;

    public DashboardPom(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        PageFactory.initElements(this.webDriver, this);
    }

    public String approve(){
//        WebElement value = webDriver.findElement(By.id(approveButtons.getAttribute("id").split("-")[2]));
        buttonCount = approveButtons.size();
        String value = approveButtons.get(0).getAttribute("id").split("-")[2];
        approveButtons.get(0).click();
        return value;
    }

    public String deny(){
//        WebElement value = webDriver.findElement(By.id(denyButton.getAttribute("id").split("-")[2]));
        buttonCount = denyButtons.size();
        String value = denyButtons.get(0).getAttribute("id").split("-")[2];
        denyButtons.get(0).click();
        return value;
    }

    public String getCurrentUrl(){
        return this.webDriver.getCurrentUrl();
    }

    public String waitForStatus(String id, String status){
        /*System.out.println(element.findElement(By.className("status")).toString());
        System.out.println(element.findElement(By.className("status")).getText());
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element.findElement(By.className("status")),"Status: " + status));
        */
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("manager-actions"), buttonCount));
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return webDriver.findElement(By.id(id)).findElement(By.className("status")).getText();
    }

    public void waitForRequests() {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("manager-actions"), 0));

    }
}

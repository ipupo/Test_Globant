import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getChromeDriver() {
        //System.setProperty("webserver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void sendKeys(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }


}

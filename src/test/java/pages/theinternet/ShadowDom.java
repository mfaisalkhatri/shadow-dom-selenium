package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import static setup.DriverManager.getDriver;

public class ShadowDom {


    public String shadowTextOne() {
        return getDriver().findElement(By.cssSelector("#content > my-paragraph:nth-child(4) > span")).getText();
    }

    public String shadowTextTwo() {
        return getDriver().findElement(By.cssSelector("#content > my-paragraph:nth-child(5) > ul:nth-child(1) > li")).getText();
    }
}

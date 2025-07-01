package pages.theinternet;

import static setup.DriverManager.getDriver;

import org.openqa.selenium.By;

public class ShadowDom {

    public String shadowTextOne () {
        return getDriver ().findElement (By.cssSelector ("#content > my-paragraph:nth-child(4) > span"))
            .getText ();
    }

    public String shadowTextTwo () {
        return getDriver ().findElement (By.cssSelector ("#content > my-paragraph:nth-child(5) > ul:nth-child(1) > li"))
            .getText ();
    }
}
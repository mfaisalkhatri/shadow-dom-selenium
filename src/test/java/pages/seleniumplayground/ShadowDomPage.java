package pages.seleniumplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import static setup.DriverManager.getDriver;

public class ShadowDomPage {

    private SearchContext getShadowRoot() {
        final WebElement shadowHost = getDriver().findElement(By.id("shadow_host"));
        return shadowHost.getShadowRoot();
    }

    private WebElement nameField() {
        return getShadowRoot().findElement(By.cssSelector("input[type=text][placeholder=Name]"));
    }

    private WebElement emailField() {
        return getShadowRoot().findElement(By.cssSelector("input[type=email][placeholder=Email]"));
    }

    public void updateDetails(String name, String email) {
        nameField().sendKeys(name);
        emailField().sendKeys(email);
    }

    public String getNameText() {
        return nameField().getAttribute("value");
    }

    public String getEmailText() {
        return emailField().getAttribute("value");
    }
}

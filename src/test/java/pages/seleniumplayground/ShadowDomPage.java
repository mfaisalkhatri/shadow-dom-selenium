package pages.seleniumplayground;

import static setup.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ShadowDomPage {

    public String getEmailText () {
        return emailField ().getAttribute ("value");
    }

    public String getNameText () {
        return nameField ().getAttribute ("value");
    }

    public void updateDetails (final String name, final String email) {
        nameField ().sendKeys (name);
        emailField ().sendKeys (email);
    }

    private WebElement emailField () {
        return getShadowRoot ().findElement (By.cssSelector ("input[type=email][placeholder=Email]"));
    }

    private SearchContext getShadowRoot () {
        final WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        return shadowHost.getShadowRoot ();
    }

    private WebElement nameField () {
        return getShadowRoot ().findElement (By.cssSelector ("input[type=text][placeholder=Name]"));
    }
}
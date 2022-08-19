package pages.watir;

import static setup.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 8/19/2022
 **/
public class HomePage {

    public String getShadowDomText() {
        WebElement shadowHost = getDriver().findElement (By.id("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        String text = shadowRoot.findElement (By.cssSelector ("#shadow_content > span")).getText ();
        return text;
    }

    public String nestedShadowDomText () {
        
    }
}

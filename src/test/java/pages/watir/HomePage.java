package pages.watir;

import static setup.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 8/19/2022
 **/
public class HomePage {

    public SearchContext expandRootElement (final WebElement element) {
        return (SearchContext) ((JavascriptExecutor) getDriver ()).executeScript (
            "return arguments[0].shadowRoot", element);
    }

    public String getSomeText () {
        return getDriver ().findElement (By.cssSelector ("#shadow_content > span"))
            .getText ();
    }

    public String getShadowDomText () {
        final WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        final SearchContext shadowRoot = shadowHost.getShadowRoot ();
        return shadowRoot.findElement (By.cssSelector ("#shadow_content > span"))
            .getText ();
    }

    public String getNestedShadowText () {
        final WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        final SearchContext shadowRoot = shadowHost.getShadowRoot ();
        final WebElement shadowContent = shadowRoot.findElement (By.cssSelector ("#nested_shadow_host"));
        final SearchContext shadowRootTwo = shadowContent.getShadowRoot ();
        return shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div"))
            .getText ();
    }

    public String getNestedText () {
        final WebElement nestedText = getDriver ().findElement (By.id ("shadow_host"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("#nested_shadow_host"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("#nested_shadow_content > div"));
        return nestedText.getText ();
    }

    public String getNestedTextUsingJSExecutor () {
        final WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        final SearchContext shadowRootOne = expandRootElement (shadowHost);
        final WebElement nestedShadowHost = shadowRootOne.findElement (By.cssSelector ("#nested_shadow_host"));
        final SearchContext shadowRootTwo = expandRootElement (nestedShadowHost);
        return shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div"))
            .getText ();

    }
}

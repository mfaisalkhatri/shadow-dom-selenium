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

    public SearchContext expandRootElement (WebElement element) {
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) getDriver ()).executeScript (
            "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }

    public String getSomeText () {
        return getDriver ().findElement (By.cssSelector ("#shadow_content > span"))
            .getText ();
    }

    public String getShadowDomText () {
        WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        String text = shadowRoot.findElement (By.cssSelector ("#shadow_content > span"))
            .getText ();
        return text;
    }

    public String getNestedShadowText () {
        WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        WebElement shadowContent = shadowRoot.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot ();
        String nestedText = shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div"))
            .getText ();
        return nestedText;
    }

    public String getNestedText () {
        WebElement nestedText = getDriver ().findElement (By.id ("shadow_host"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("#nested_shadow_host"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("#nested_shadow_content > div"));
        return nestedText.getText ();
    }

    public String getNestedTextUsingJSExecutor () {
        WebElement shadowHost = getDriver ().findElement (By.id ("shadow_host"));
        SearchContext shadowRootOne = expandRootElement (shadowHost);
        WebElement nestedShadowHost = shadowRootOne.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = expandRootElement (nestedShadowHost);
        return shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div"))
            .getText ();

    }
}

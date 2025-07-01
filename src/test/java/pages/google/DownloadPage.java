package pages.google;

import static setup.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class DownloadPage {

    public String downloadPageHeaderText () {

        final WebElement downloadsManager = getDriver ().findElement (By.tagName ("downloads-manager"));
        final SearchContext shadowRoot = downloadsManager.getShadowRoot ();
        final WebElement toolbar = shadowRoot.findElement (By.id ("toolbar"));
        final SearchContext shadowRootTwo = toolbar.getShadowRoot ();
        final WebElement crToolbar = shadowRootTwo.findElement (By.cssSelector ("cr-toolbar"));
        final SearchContext shadowRootThree = crToolbar.getShadowRoot ();
        final WebElement downloadsHeader = shadowRootThree.findElement (By.cssSelector ("#leftSpacer > h1"));
        return downloadsHeader.getText ();
    }

    public SearchContext expandRootElement (final WebElement element) {
        final SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) getDriver ()).executeScript (
            "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }

    public String googleDownloadPageHeaderText () {
        final WebElement pageHeader = getDriver ().findElement (By.tagName ("downloads-manager"))
            .getShadowRoot ()
            .findElement (By.id ("toolbar"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("cr-toolbar"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("#leftSpacer > h1"));
        return pageHeader.getText ();
    }

    public String pageHeaderTextUsingJScripExecutor () {
        final WebElement downloadsManagerTag = getDriver ().findElement (By.tagName ("downloads-manager"));
        final SearchContext shadowRootOne = expandRootElement (downloadsManagerTag);
        final WebElement toolbar = shadowRootOne.findElement (By.id ("toolbar"));
        final SearchContext shadowRootTwo = expandRootElement (toolbar);
        final WebElement crToolbar = shadowRootTwo.findElement (By.cssSelector ("cr-toolbar"));
        final SearchContext shadowRootThree = expandRootElement (crToolbar);
        return shadowRootThree.findElement (By.cssSelector ("#leftSpacer > h1"))
            .getText ();

    }
}
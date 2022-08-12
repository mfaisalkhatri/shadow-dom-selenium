package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import static setup.DriverManager.getDriver;

public class DownloadPage {

    public SearchContext expandRootElement (WebElement element) {
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) getDriver ()).executeScript (
            "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }

    public String pageHeaderTextUsingJScripExecutor () {
        WebElement downloadsManagerTag = getDriver ().findElement (By.tagName ("downloads-manager"));
        SearchContext shadowRootOne = expandRootElement (downloadsManagerTag);
        WebElement toolbar = shadowRootOne.findElement (By.id ("toolbar"));
        SearchContext shadowRootTwo = expandRootElement (toolbar);
        WebElement crToolbar = shadowRootTwo.findElement (By.cssSelector ("cr-toolbar"));
        SearchContext shadowRootThree = expandRootElement (crToolbar);
        return shadowRootThree.findElement (By.cssSelector ("#leftSpacer > h1"))
            .getText ();

    }

    public String downloadPageHeaderText () {

        WebElement downloadsManager = getDriver ().findElement (By.tagName ("downloads-manager"));
        SearchContext shadowRoot = downloadsManager.getShadowRoot ();
        WebElement toolbar = shadowRoot.findElement (By.id ("toolbar"));
        SearchContext shadowRootTwo = toolbar.getShadowRoot ();
        WebElement crToolbar = shadowRootTwo.findElement (By.cssSelector ("cr-toolbar"));
        SearchContext shadowRootThree = crToolbar.getShadowRoot ();
        WebElement downloadsHeader = shadowRootThree.findElement (By.cssSelector ("#leftSpacer > h1"));
        return downloadsHeader.getText ();
    }

    public String googleDownloadPageHeaderText () {
        WebElement pageHeader = getDriver ().findElement (By.tagName ("downloads-manager"))
            .getShadowRoot ()
            .findElement (By.id ("toolbar"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("cr-toolbar"))
            .getShadowRoot ()
            .findElement (By.cssSelector ("#leftSpacer > h1"));
        return pageHeader.getText ();
    }

}


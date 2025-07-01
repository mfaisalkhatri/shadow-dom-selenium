package pages.htmlelements;

import static setup.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebElement editMenu () {
        final WebElement shadowHost = getDriver ().findElement (By.cssSelector (".smart-ui-component"));
        final SearchContext shadowRoot = expandRootElement (shadowHost);
        return shadowRoot.findElement (
            By.cssSelector (".smart-element .smart-menu-main-container smart-menu-items-group:nth-child(2)"));
    }

    public SearchContext expandRootElement (final WebElement element) {
        return (SearchContext) ((JavascriptExecutor) getDriver ()).executeScript ("return arguments[0].shadowRoot",
            element);
    }

    public WebElement fileMenu () {
        final WebElement shadowHost = getDriver ().findElement (By.cssSelector (".smart-ui-component"));
        final SearchContext shadowRoot = shadowHost.getShadowRoot ();
        return shadowRoot.findElement (By.cssSelector (".smart-element .smart-menu-main-container .smart-element"));
    }

    public String getEditMenuText () {
        return editMenu ().getAttribute ("label");
    }

    public String getFileMenuText () {
        return fileMenu ().getAttribute ("label");
    }

    public String getNewMenuText () {
        openFileMenu ();
        return fileMenu ().findElement (By.cssSelector (".smart-menu-drop-down div smart-menu-item.smart-element"))
            .getAttribute ("label");
    }

    public String getUndoMenuText () {
        openEditMenu ();
        return editMenu ().findElement (By.cssSelector (".smart-menu-drop-down div smart-menu-item.smart-element"))
            .getAttribute ("label");
    }

    public void openEditMenu () {
        editMenu ().click ();
    }

    public void openFileMenu () {
        fileMenu ().click ();
    }
}

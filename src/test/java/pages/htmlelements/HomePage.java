package pages.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import static setup.DriverManager.getDriver;

public class HomePage {

    public WebElement fileMenu() {
        final WebElement shadowHost = getDriver().findElement(By.cssSelector(".smart-ui-component"));
        final SearchContext shadowRoot = shadowHost.getShadowRoot();
        return shadowRoot.findElement(By.cssSelector(".smart-element .smart-menu-main-container .smart-element"));
    }

    public String getFileMenuText() {
        return fileMenu().getAttribute("label");
    }

    public void openFileMenu() {
        fileMenu().click();
    }

    public String getNewMenuText() {
        openFileMenu();
        return fileMenu().findElement(By.cssSelector(".smart-menu-drop-down div smart-menu-item.smart-element"))
                .getAttribute("label");
    }
}

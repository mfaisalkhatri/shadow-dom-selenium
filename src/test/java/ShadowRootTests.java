import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.htmlelements.HomePage;

import static org.testng.Assert.assertEquals;
import static setup.DriverManager.getDriver;

public class ShadowRootTests extends BaseTest {

    @BeforeClass
    public void navigateToWebsite() {
        getDriver().get("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");
    }

    @Test
    public void testFileMenuShadowRootElement() {
        final HomePage homePage = new HomePage();
        assertEquals(homePage.getFileMenuText(), "File");
    }

    @Test
    public void testNewMenuShadowRootElement() {
        final HomePage homePage = new HomePage();
        assertEquals(homePage.getNewMenuText(), "New");
    }

    @Test
    public void testEditMenuShadowRootElement() {
        final HomePage homePage = new HomePage();
        assertEquals(homePage.getEditMenuText(), "Edit");
    }

    @Test
    public void testUndoMenuShadowRootElement() {
        final HomePage homePage = new HomePage();
        assertEquals(homePage.getUndoMenuText(), "Undo");
    }
}

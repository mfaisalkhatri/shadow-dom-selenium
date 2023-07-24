import org.testng.annotations.Test;
import pages.htmlelements.HomePage;

import static org.testng.Assert.assertEquals;
import static setup.DriverManager.getDriver;

public class ShadowRootTests extends BaseTest {

    @Test
    public void testShadowRootElement() {

        getDriver().get("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");

        final HomePage homePage = new HomePage();
        assertEquals(homePage.getFileMenuText(), "File");
        assertEquals(homePage.getNewMenuText(), "New");

    }
}

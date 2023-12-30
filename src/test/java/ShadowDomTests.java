import org.testng.annotations.Test;
import pages.google.DownloadPage;
import pages.seleniumplayground.ShadowDomPage;
import pages.theinternet.ShadowDom;
import pages.watir.HomePage;

import static org.testng.Assert.assertEquals;
import static setup.DriverManager.getDriver;

public class ShadowDomTests extends BaseTest {

    @Test
    public void testShadowDom () {
        getDriver ().get ("https://the-internet.herokuapp.com/shadowdom");
        final ShadowDom shadowDom = new ShadowDom ();
        assertEquals (shadowDom.shadowTextOne (), "Let's have some different text!");
        System.out.println (shadowDom.shadowTextTwo ());
    }

    @Test
    public void testShadowDomRootOnChromeDownloadPage () {
        getDriver ().get ("chrome://downloads/");
        final DownloadPage downloadPage = new DownloadPage ();
        assertEquals (downloadPage.downloadPageHeaderText (), "Downloads");
        assertEquals (downloadPage.googleDownloadPageHeaderText (), "Downloads");
        assertEquals (downloadPage.pageHeaderTextUsingJScripExecutor (), "Downloads");
    }

    @Test
    public void testShadowDomWatir () {
        getDriver ().get ("http://watir.com/examples/shadow_dom.html");
        final HomePage homePage = new HomePage ();
        // assertEquals (homePage.getSomeText(), "some text");
        assertEquals (homePage.getShadowDomText (), "some text");
        assertEquals (homePage.getNestedShadowText (), "nested text");
        assertEquals (homePage.getNestedText (), "nested text");
        assertEquals (homePage.getNestedTextUsingJSExecutor (), "nested text");
    }

    @Test
    public void testShadowDomSeleniumPlayground() {
        getDriver().get("https://www.lambdatest.com/selenium-playground/shadow-dom");
        ShadowDomPage shadowDomPage = new ShadowDomPage();
        String name = "faisal";
        String email = "faisal.k@gmail.com";
        shadowDomPage.updateDetails(name, email);
        assertEquals(shadowDomPage.getNameText(), name);
        assertEquals(shadowDomPage.getEmailText(), email);
    }
}

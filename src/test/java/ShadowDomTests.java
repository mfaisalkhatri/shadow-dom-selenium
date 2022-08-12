import org.testng.annotations.Test;
import pages.google.DownloadPage;
import pages.theinternet.ShadowDom;

import static org.testng.Assert.assertEquals;
import static setup.DriverManager.getDriver;

public class ShadowDomTests extends BaseTest {


    @Test
    public void testShadowDom() {
        getDriver().get("https://the-internet.herokuapp.com/shadowdom");
        ShadowDom shadowDom = new ShadowDom();
        assertEquals(shadowDom.shadowTextOne(),"Let's have some different text!");
        System.out.println(shadowDom.shadowTextTwo());
    }

    @Test
    public void testShadowDomRootOnChromeDownloadPage () {
        getDriver().get("chrome://downloads/");
        DownloadPage downloadPage = new DownloadPage();
        assertEquals(downloadPage.downloadPageHeaderText (),"Downloads");
        assertEquals(downloadPage.googleDownloadPageHeaderText (),"Downloads");
        assertEquals (downloadPage.pageHeaderTextUsingJScripExecutor(), "Downloads");
    }



}

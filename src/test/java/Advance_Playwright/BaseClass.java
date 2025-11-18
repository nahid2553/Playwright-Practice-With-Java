package Advance_Playwright;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseClass {
    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
      //  browser = playwright.chromium().launch();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }
    @AfterAll
    static void closeBrowser(){
        playwright.close();
    }
    @BeforeEach
    void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
    }
    @AfterEach
    void closeContext(){
        context.close();
    }

}

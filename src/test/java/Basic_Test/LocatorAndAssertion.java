package Basic_Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LocatorAndAssertion {
    static Playwright playwright;
    static Browser browser;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
      //  browser = playwright.chromium().launch();
    }

    @BeforeEach
    void createPage() {
        page = browser.newPage();
    }

    @AfterEach
    void closePage() {
        page.close();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @Test
    void testTryTesting() {
        page.navigate("https://trytestingthis.netlify.app");
        System.out.println(page.title());
        assertThat(page).hasTitle(Pattern.compile("Testing"));

        Locator contact = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Contact"));
        assertThat(contact).hasAttribute("href", "/contact");
        contact.click();

        assertThat(page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions()
                .setName("Your Website to practice Automation Testing"))).isVisible();
    }

    @Test
    void wikipedia() {
        page.navigate("https://www.facebook.com/");

//        1.Locate by text content
        Locator byText = page.getByText("Facebook helps you");
        Locator byExactText = page.getByText("Facebook helps you connect and share with the people in your life.",new Page.GetByTextOptions().setExact(true));
        System.out.println(byExactText);

//        Button with text
        page.getByText("Create new account").click();

//        Link with Text for button
        page.getByText("Log in").click();

//        link text


//        2.Locate by Test ID
//        page.getByTestId("open-registration-form-button").click();

//        3.Locate by placeholder
//        4.Locate by Title
//        5.Locate by ALT Text
//        6.Locate by Label Text

    }
}
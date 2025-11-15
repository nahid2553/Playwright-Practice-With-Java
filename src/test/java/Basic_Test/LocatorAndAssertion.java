package Basic_Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LocatorAndAssertion {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
            Page page = browser.newPage();
            page.navigate("https://trytestingthis.netlify.app");
            System.out.println(page.title());
            assertThat(page).hasTitle(Pattern.compile("Testing"));
            //add extra timeout//
//            assertThat(page).hasTitle(Pattern.compile("Testing"), new PageAssertions.HasTitleOptions().setTimeout(1000));
            Locator contact = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact"));
            assertThat(contact).hasAttribute("href", "/contact");  //attribute which contain url and its value
            contact.click();  //click on element
            assertThat(page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Your Website to practice Automation Testing"))).isVisible();


        }
    }
}


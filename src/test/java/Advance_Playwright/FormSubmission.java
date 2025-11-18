package Advance_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormSubmission extends BaseClass{

    @Test
    void clickSignUpForm(){
        page.navigate("https://qavbox.github.io/demo/");
        assertThat(page.locator("a[href='/demo/signup']")).isVisible();
        page.locator("a[href='/demo/signup']").click();
//        assertThat(page).hasURL("https://qavbox.github.io/demo/signup/");
        String Name = page.getByText("Full N").textContent();
        System.out.println(Name);
        page.locator("//input[@id='username']").fill("S M Nahid Iqbal");

        String gender = page.getByText("Gender:").textContent();
        System.out.println(gender);
        page.locator("//select[@name='sgender']").click();
        page.locator("select[name='sgender']").selectOption("male");
        page.locator("select[name='sgender']").selectOption("female");
        page.locator("select[name='sgender']").selectOption("na");
    }
    @Test
    void FillSignUpForm(){
        page.navigate("https://qavbox.github.io/demo/signup/");
    }

}

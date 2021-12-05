import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Register extends BaseTest {
    private final Person person;

    // input fields
    By nameInput = By.cssSelector("#firstName");
    By lastInput = By.cssSelector("#lastName");
    By genderRadio;
    By numberInput = By.cssSelector("#userNumber");

    // submit button
    By submitBtn = By.cssSelector("button#submit");

    // modal title
    By modalTitle = By.cssSelector(".modal-title");

    public Register(Person person) {
        this.person = person;

        // set gender radio based on object
        genderRadio = By.cssSelector("input[value='" + person.gender + "']");
    }

    public void execute() {
        System.out.println($(nameInput));
        // fill out form
        $(nameInput).shouldBe(Condition.visible)
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}")
                .sendKeys(person.first);
        $(lastInput).sendKeys(person.last);
        $(genderRadio)
                .parent().click();
        $(numberInput).sendKeys(person.number);

        // submit form
        $(submitBtn)
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}")
                .click();

        // check that submit text is visible
        $(modalTitle).shouldHave(Condition.text("Thanks for submitting the form"));

        // check that table content is correct
        $(".modal-body table tbody :nth-child(1) :nth-child(2)")
                .shouldBe(Condition.text(person.first + " " + person.last));

        $(".modal-body table tbody :nth-child(3) :nth-child(2)")
                .shouldBe(Condition.text(person.gender));

        $(".modal-body table tbody :nth-child(4) :nth-child(2)")
                .shouldBe(Condition.text(person.number));
    }
}

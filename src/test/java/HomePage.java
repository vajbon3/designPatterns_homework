import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BaseTest {
    By FormsBtn = By.cssSelector(".category-cards .card:nth-child(2)");

    public void clickForms() {
        $(FormsBtn)
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}")
                .click();
    }
}

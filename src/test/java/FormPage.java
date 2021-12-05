import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FormPage extends BaseTest {
    By practiceBtn = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li");

    public void clickPractice() {
        $(practiceBtn)
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}")
                .shouldBe(Condition.visible)
                .click();
    }
}

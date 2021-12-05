import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    @DataProvider(name = "person-provider")
    public Object[][] dpMethod() {
        return new Object[][] {
                {new Person("Vaja","Chelidze","Male","5742187741")},
                {new Person("Mikheil", "Saakashvili", "Male", "5742187741")}
        };
    };

    @Test(dataProvider = "person-provider")
    public void test(Person person) {
        open("https://demoqa.com/");
        // home page
        var home = new HomePage();
        home.clickForms();

        // form page
        var form = new FormPage();
        form.clickPractice();

        // registration
        var register = new Register(person);
        register.execute();
    }
}

package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WikiTestSelenide {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void WeNeedJunitCode() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text(
                        "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "@Test\n" +
                        "void test() {\n" +
                        "Configuration.assertionMode = SOFT;\n" +
                        "open(\"page.html\");\n" +
                        "\n" +
                        "$(\"#first\").should(visible).click();\n" +
                        "$(\"#second\").should(visible).click();\n" +
                        "}\n" +
                        "}"
        ));
    }
}

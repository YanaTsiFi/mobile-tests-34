package tests.ios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class IosArticleTest extends TestBase {

    @BeforeAll
    static void setup() {
        System.setProperty("platform", "ios");
    }

    @Test
    void openSelenideTest() {
        step("Type search", () -> {
            $(accessibilityId("Text Button")).click();
            $(accessibilityId("Text Input")).sendKeys("Selenide" + "\n");
        });

        step("Verify content found", () ->
                $$(accessibilityId("Text Output"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
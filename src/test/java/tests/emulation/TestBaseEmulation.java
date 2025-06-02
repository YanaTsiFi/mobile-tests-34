package tests.emulation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.EmulationDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseEmulation {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("deviceHost", "emulation");

        Configuration.browser = EmulationDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        Configuration.remoteReadTimeout = 60000;
        Configuration.remoteConnectionTimeout = 60000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}
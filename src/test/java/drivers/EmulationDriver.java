package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulationConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulationDriver implements WebDriverProvider {

    private static final EmulationConfig config = ConfigFactory.create(EmulationConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setCapability("platformName", "Android");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setDeviceName(config.deviceName());
        options.setPlatformName(config.platformName());
        options.setPlatformVersion(config.platformVersion());
        options.setApp(new File(config.appPath()).getAbsolutePath().replace("/", "\\"));
        options.setAppPackage(config.appPackage());
        options.setAppActivity(config.appActivity());
        options.setAutomationName(config.automationName());

        System.out.println("Appium Options:");
        System.out.println("Device: " + config.deviceName());
        System.out.println("Platform: " + config.platformName());
        System.out.println("Version: " + config.platformVersion());
        System.out.println("App: " + config.appPath());
        System.out.println("Package: " + config.appPackage());
        System.out.println("Activity: " + config.appActivity());
        System.out.println("Automation: " + config.automationName());
        System.out.println("URL: " + config.appiumUrl());

        try {
            return new AndroidDriver(new URL(config.appiumUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }
}
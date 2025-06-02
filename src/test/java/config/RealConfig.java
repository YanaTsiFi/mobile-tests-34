package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:real.properties"
})
public interface RealConfig extends Config {
    @Key("platform.name")
    String platformName();

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("app.path")
    String appPath();

    @Key("appium.url")
    String appiumUrl();

    @Key("automation.name")
    String automationName();
}
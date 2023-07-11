package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:common.properties"
})

public interface ProjectConfig extends Config {
    @Config.DefaultValue("chrome")
    @Config.Key("browser")
    String browser();

    @Config.DefaultValue("91.0")
    @Config.Key("browserVersion")
    String browserVersion();

    @Config.DefaultValue("1920x1080")
    @Config.Key("browserSize")
    String browserSize();

    @Config.DefaultValue("http://localhost:8083/wd/hub")
    @Config.Key("remoteDriverUrl")
    String remoteDriverUrl();

    @Config.DefaultValue("http://localhost:8083/video/")
    @Config.Key("videoStorage")
    String videoStorage();

    @Config.Key("accountUsername")
    String accountUsername();

    @Config.Key("accountPassword")
    String accountPassword();

    @Config.DefaultValue("https://trello.com/")
    @Config.Key("baseUrl")
    String baseUrl();
}
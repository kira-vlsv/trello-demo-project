package helpers;

import com.codeborne.selenide.Configuration;
import config.Project;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Project.config;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = config.baseUrl();
        Configuration.timeout = 10000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

//        if (Project.isRemoteWebDriver()) {
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//            Configuration.remote = Project.config.remoteDriverUrl();
//        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}

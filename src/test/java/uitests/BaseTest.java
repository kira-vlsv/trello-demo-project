package uitests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import config.Project;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import uitests.pageobjects.mainpage.MainPage;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static config.Auth.authConfig;

public abstract class BaseTest {

    protected final MainPage mainPage = new MainPage();
    protected final Faker faker = new Faker();

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @BeforeEach
    @Step("Login to the Trello")
    public void login() {
        open("/login");
        $(byId("user")).setValue(authConfig.userLogin()).pressEnter();
        $(byId("password")).setValue(authConfig.userPassword()).pressEnter();
    }

    @AfterEach
    public void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        if (Project.isVideoOn()) {
            AllureAttachments.addVideo();
        }
        Selenide.closeWebDriver();
    }
}

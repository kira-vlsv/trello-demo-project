package uitests.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;

public class Button {

    private SelenideElement element;

    public Button(SelenideElement element) {
        this.element = element;
    }

    public void click() {
        element.shouldBe(enabled).click();
    }
}

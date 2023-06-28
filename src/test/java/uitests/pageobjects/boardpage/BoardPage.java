package uitests.pageobjects.boardpage;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BoardPage {

    public BoardPage() {
        $(".board-wrapper .board-main-content").shouldBe(Condition.exist);
    }

    @Step("Create list on the board")
    public void createList(String listName) {
        $(".js-open-add-list").click();
        $(".list-name-input").setValue(listName);
        $(".mod-list-add-button").click();
    }

    @Step("Create card in the '{listName}' list")
    public void createCard(String listName, String cardName) {
        $(byText(listName)).closest(".js-list-content").$(".icon-add").click();
        $(".list-card-composer-textarea").setValue(cardName);
        $(".js-add-card").click();
    }

    @Step("Verify board name")
    public void verifyBoardName(String boardName) {
        $("[data-testid=board-name-display]").shouldBe(exist).shouldHave(text(boardName));
    }

    @Step("Verify card is created and displayed in the list")
    public void verifyCardIsCreatedAndDisplayedInTheList(String listName, String cardName) {
        $(byText(listName))
                .closest(".js-list-content")
                .$$("[data-testid=trello-card]")
                .shouldHave(itemWithText(cardName));
    }
}

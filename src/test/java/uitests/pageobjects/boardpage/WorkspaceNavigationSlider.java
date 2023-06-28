package uitests.pageobjects.boardpage;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WorkspaceNavigationSlider {

    private final ElementsCollection boardsList = $(byText("Your boards"))
            .closest("[data-testid=collapsible-list]")
            .$$("[data-testid=collapsible-list-items] li");

    @Step("Verify board name is displayed in workspace navigation slider")
    public void verifyBoardInList(String boardName) {
        boardsList.shouldHave(itemWithText(boardName));
    }
}

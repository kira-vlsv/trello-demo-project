package uitests.pageobjects.mainpage;

import io.qameta.allure.Step;
import uitests.pageobjects.BasePage;
import uitests.pageobjects.boardpage.BoardPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateBoardSlider extends BasePage {

    public CreateBoardSlider() {
        $(".atlaskit-portal").shouldBe(visible);
    }

    @Step("Fill in board title")
    public CreateBoardSlider setBoardName(String boardName) {
        $("[data-testid=create-board-title-input]").setValue(boardName);
        return new CreateBoardSlider();
    }

    @Step("Click on 'Create' button")
    public BoardPage createBoard() {
        $("[data-testid=create-board-submit-button]")
                .shouldBe(enabled).click();
        return new BoardPage();
    }
}

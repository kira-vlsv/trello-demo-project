package uitests.pageobjects.mainpage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import uitests.elements.Button;
import uitests.pageobjects.BasePage;
import uitests.pageobjects.boardpage.BoardPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateBoardSlider extends BasePage {

    private final Button createBoard = new Button($("[data-testid=create-board-submit-button]"));
    private final SelenideElement nameInput = $("[data-testid=create-board-title-input]");

    public CreateBoardSlider() {
        $(".atlaskit-portal").shouldBe(visible);
    }

    @Step("Fill in board title")
    public CreateBoardSlider setBoardName(String boardName) {
        nameInput.setValue(boardName);
        return new CreateBoardSlider();
    }

    @Step("Click on 'Create' button")
    public BoardPage createBoard() {
        createBoard.click();
        return new BoardPage();
    }
}

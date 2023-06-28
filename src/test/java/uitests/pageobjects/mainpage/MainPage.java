package uitests.pageobjects.mainpage;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import uitests.pageobjects.boardpage.BoardPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    @Step("Open create new board slider")
    public CreateBoardSlider openCreateBoardSlider() {
        $("[data-testid=create-board-tile]").click();
        return new CreateBoardSlider();
    }

    @Step("Open '{boardName}' board")
    public BoardPage openBoard(String workspaceName, String boardName) {
        getBoardsOfWorkspace(workspaceName).findBy(text(boardName)).click();
        return new BoardPage();
    }

    @Step("Get boards list of '{workspaceName}' section")
    public ElementsCollection getBoardsOfWorkspace(String workspaceName) {
        return $$(".boards-page-board-section-header-name")
                .findBy(text(workspaceName))
                .closest(".boards-page-board-section")
                .$$(".boards-page-board-section-list-item");
    }

}

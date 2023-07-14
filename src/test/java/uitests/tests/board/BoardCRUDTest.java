package uitests.tests.board;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uitests.tests.BaseUITest;
import uitests.pageobjects.boardpage.BoardPage;
import uitests.pageobjects.mainpage.CreateBoardSlider;
import uitests.pageobjects.boardpage.WorkspaceNavigationSlider;

import static utils.RandomGenerator.randomString;

@Tag("Regression")
class BoardCRUDTest extends BaseUITest {

    private BoardPage boardPage;
    private CreateBoardSlider createBoardSlider;
    private WorkspaceNavigationSlider workspaceNavigationSlider = new WorkspaceNavigationSlider();

    @Test
    @Feature("Trello board")
    @Story("As a user I can create a board from the Main Page")
    @DisplayName("Create new board from Main Page")
    void createBoard() {
        String boardName = randomString("Board");
        createBoardSlider = mainPage.openCreateBoardSlider();
        boardPage = createBoardSlider.setBoardName(boardName)
                .createBoard();
        boardPage.verifyBoardName(boardName);
        workspaceNavigationSlider.verifyBoardInList(boardName);
    }
}

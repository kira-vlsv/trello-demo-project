package uitests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.pageobjects.boardpage.BoardPage;
import uitests.pageobjects.mainpage.CreateBoardSlider;
import uitests.pageobjects.boardpage.WorkspaceNavigationSlider;

public class BoardCRUDTest extends BaseTest {

    private BoardPage boardPage;
    private CreateBoardSlider createBoardSlider;
    private WorkspaceNavigationSlider workspaceNavigationSlider = new WorkspaceNavigationSlider();

    @Test
    @Feature("Trello board")
    @Story("As a user I can create a board from the Main Page")
    @DisplayName("Create new board from Main Page")
    public void createBoard() {
        String boardName = faker.rockBand().name();
        createBoardSlider = mainPage.openCreateBoardSlider();
        boardPage = createBoardSlider.setBoardName(boardName)
                .createBoard();
        boardPage.verifyBoardName(boardName);
        workspaceNavigationSlider.verifyBoardInList(boardName);
    }
}

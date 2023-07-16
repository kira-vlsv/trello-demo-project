package apitests.steps;

import apitests.apiobjects.BoardApiObj;
import apitests.dto.BoardDTO;
import io.qameta.allure.Step;

public class BoardSteps {

    @Step("Create board with only required fields")
    public static BoardDTO createBoardWithRequiredFields(String boardName) {
        BoardDTO boardDTORequest = new BoardDTO()
                .setName(boardName);
        return new BoardApiObj()
                .createBoard(boardDTORequest)
                .as(BoardDTO.class);
    }
}

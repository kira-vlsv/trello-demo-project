package apitests.tests;

import apitests.apiobjects.BoardApiObj;
import apitests.dto.BoardDTO;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static apitests.steps.BoardSteps.createBoardWithRequiredFields;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.RandomGenerator.randomString;

@Tag("Regression")
@Tag("Positive")
class BoardCRUDPositiveTest extends BaseAPITest {

    BoardApiObj boardApiObj = new BoardApiObj();
    BoardDTO boardDTORequest,
            boardDTOCreateResponse,
            boardDTOGetResponse;
    List<String> boardIdsToDelete = new ArrayList<>();

    @AfterEach
    void teardown() {
        step("Teardown - Delete boards", () -> {
            for (String id : boardIdsToDelete) {
                boardApiObj.deleteBoard(id);
            }
        });
    }

    @Test
    @Feature("Trello board")
    @Story("As a user I can create a board using API")
    @DisplayName("Create new board using API")
    void createBoardWithRequiredParameters() {
        String boardName = randomString("Board");

        step("Step 1 - Create board", () -> {
            boardDTOCreateResponse = createBoardWithRequiredFields(boardName);
            assertThat(boardDTOCreateResponse.getName()).isEqualTo(boardName);
            boardIdsToDelete.add(boardDTOCreateResponse.getId());
        });

        step("Step 2 - Get board by ID and verify fields", () -> {
            boardDTOGetResponse = boardApiObj
                    .getBoard(boardDTOCreateResponse.getId())
                    .as(BoardDTO.class);
            boardDTOCreateResponse.setLimits(null); // todo refactor verification
            assertThat(boardDTOGetResponse).isEqualTo(boardDTOCreateResponse);
        });
        System.out.println(boardIdsToDelete.toString());
    }

    @Test
    @Feature("Trello board")
    @Story("As a user I can update a board using API")
    @DisplayName("Update a board using API")
    void updateBoardNameAndDescription() {
        String boardName = randomString("Board");
        String boardNameNew = randomString("Board");
        String boardDescNew = randomString("Description");

        step("Setup - Create board", () -> {
            boardDTOCreateResponse = createBoardWithRequiredFields(boardName);
        });

        boardIdsToDelete.add(boardDTOCreateResponse.getId());

        boardDTORequest = new BoardDTO().setName(boardNameNew)
                .setDesc(boardDescNew)
                .setClosed(true);

        BoardDTO boardDTOUpdateResponse = step("Step 1 - Update board", () ->
            boardApiObj
                    .updateBoard(boardDTOCreateResponse.getId(), boardDTORequest)
                    .as(BoardDTO.class)
        );

        step("Step 2 - Get board by ID and verify fields", () -> {
            boardDTOGetResponse = boardApiObj
                    .getBoard(boardDTOCreateResponse.getId())
                    .as(BoardDTO.class);
            assertThat(boardDTOGetResponse.getName()).isEqualTo(boardNameNew);
            assertThat(boardDTOGetResponse.getDesc()).isEqualTo(boardDescNew);
            assertThat(boardDTOGetResponse.isClosed()).isTrue();
        });
        System.out.println(boardIdsToDelete.toString());
    }

    @Test
    @Feature("Trello board")
    @Story("As a user I can delete a board using API")
    @DisplayName("Delete a board using API")
    void deleteBoard() {
        String boardName = randomString("Board");

        step("Setup - Create board", () -> {
            boardDTOCreateResponse = createBoardWithRequiredFields(boardName);
        });

        step("Step 1 - Delete board by ID", () -> {
            boardApiObj.deleteBoard(boardDTOCreateResponse.getId());
        });

        step("Step 2 - Get board by ID and verify error code is returned", () -> {
            boardApiObj.getNonExistentBoard(boardDTOCreateResponse.getId());
        });
    }
}

package apitests.tests;

import apitests.apiobjects.BoardApiObj;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static apitests.endpoint.BoardEndPoint.BASE_BOARDS_URL;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("Regression")
@Tag("Negative")
class BoardCRUDNegativeTest extends BaseAPITest {

    @Test
    @Feature("Trello board")
    @Story("Add validations for board creation API - /1/boards")
    @DisplayName("Create board with empty payload")
    void createBoardWithEmptyPayload() {
        Response response = step("Step 1 - Try to create board without body", () ->
                new BoardApiObj().requestPostWithoutBody(BASE_BOARDS_URL)
        );

        step("Step 2 - Verify error message", () -> {
            assertThat((String) response.path("message")).isEqualTo("invalid value for name");
            assertThat((String) response.path("error")).isEqualTo("ERROR");
        });
    }
}

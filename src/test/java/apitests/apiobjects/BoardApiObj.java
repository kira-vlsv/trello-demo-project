package apitests.apiobjects;

import apitests.dto.BoardDTO;
import io.restassured.response.Response;

import static apitests.endpoint.BoardEndPoint.BASE_BOARDS_URL;
import static apitests.endpoint.BoardEndPoint.BOARD_URL;

public class BoardApiObj extends BaseApiObject {

    public Response createBoard(BoardDTO boardDTO) {
        return requestPost(BASE_BOARDS_URL, boardDTO);
    }

    public Response getBoard(String id) {
        String path = String.format(BOARD_URL, id);
        return requestGet(path);
    }

    public Response updateBoard(String id, BoardDTO boardDTO) {
        String path = String.format(BOARD_URL, id);
        return requestPut(path, boardDTO);
    }

    public Response deleteBoard(String id) {
        String path = String.format(BOARD_URL, id);
        return requestDelete(path);
    }

    public Response getNonExistentBoard(String id) {
        String path = String.format(BOARD_URL, id);
        return requestNegativeGet(path);
    }
}
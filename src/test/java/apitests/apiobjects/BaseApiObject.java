package apitests.apiobjects;

import apitests.dto.BaseDTO;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static apitests.specs.BaseSpecification.baseRequestSpecification;
import static apitests.specs.BaseSpecification.baseResponseSpecification;
import static io.restassured.RestAssured.given;

public class BaseApiObject {

    private Response response;

    protected Response requestGet(String path) {
        response = given(baseRequestSpecification(path))
                .get();
        checkCode(HttpStatus.SC_OK, response);
        return response;
    }

    protected Response requestNegativeGet(String path) {
        response = given(baseRequestSpecification(path))
                .get();
        checkCode(HttpStatus.SC_NOT_FOUND, response);
        return response;
    }

    protected Response requestPost(String path, BaseDTO dto) {
        response = given(baseRequestSpecification(path))
                .body(dto)
                .post();
        checkCode(HttpStatus.SC_OK, response);
        return response;
    }

    protected Response requestPut(String path, BaseDTO dto) {
        response = given(baseRequestSpecification(path))
                .body(dto)
                .put();
        checkCode(HttpStatus.SC_OK, response);
        return response;
    }

    protected Response requestDelete(String path) {
        response = given(baseRequestSpecification(path))
                .delete();
        checkCode(HttpStatus.SC_OK, response);
        return response;
    }

    private void checkCode(Integer httpStatus, Response response) {
        response.then().spec(baseResponseSpecification(httpStatus));
    }

}

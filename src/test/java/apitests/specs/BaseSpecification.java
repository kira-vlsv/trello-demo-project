package apitests.specs;

import config.APIAuth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.HEADERS;
import static io.restassured.filter.log.LogDetail.METHOD;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.filter.log.LogDetail.URI;

public class BaseSpecification {

    public static RequestSpecification baseRequestSpecification(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(APIAuth.config.uri())
                .addQueryParam("key", APIAuth.config.key())
                .addQueryParam("token", APIAuth.config.token())
                .setContentType(ContentType.JSON)
                .setBasePath(path)
                .log(METHOD).log(URI).log(HEADERS).log(BODY).build();
    }

    public static ResponseSpecification baseResponseSpecification(Integer statusCode) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(statusCode)
                .build();
    }

}

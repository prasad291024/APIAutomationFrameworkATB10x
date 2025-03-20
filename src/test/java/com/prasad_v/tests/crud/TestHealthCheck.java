package com.prasad_v.tests.crud;

import com.prasad_v.APIConstants;
import com.prasad_v.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {
    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Promode")
    @Description("TC#3  - Verify Health")
    public void testGETHealthCheck() {
        requestSpecification.basePath(APIConstants.PING_URL);
        response = RestAssured.given(requestSpecification)
                .when()
                .get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}
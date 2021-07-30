package com.virgingames.bingoinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class BingoSteps {

    @Step("Getting the information of bingo live feed")
    public ValidatableResponse getBingoLiveFeedInfo() {

        return SerenityRest.rest()
                .given().log().all()
                .contentType( ContentType.TEXT )
                .when()
                .get( EndPoints.GET_BINGO_LOBBY_FEED )
                .then().log().all();
    }




}

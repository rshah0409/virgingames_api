package com.virgingames.testsuite;

import com.virgingames.bingoinfo.BingoSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
public class BingoCRUDTest extends TestBase {

    @Steps
    BingoSteps bingoSteps;

    @Test
    public void getAllLiveFeedAndAssertDefaultGameFrequency() {
        ValidatableResponse response =

                bingoSteps.getBingoLiveFeedInfo().statusCode( 200 );
        int gameFrequency = response.extract().jsonPath().getInt( "bingoLobbyInfoResource.streams[6].defaultGameFrequency" );
        assertThat( gameFrequency, equalTo( 300000 ) );

        System.out.println( "Game frequency Is :  " + gameFrequency );

    }

    @Test
    public void getAllLiveFeedAndAssertStartTime() {
        ValidatableResponse response =

                bingoSteps.getBingoLiveFeedInfo().statusCode( 200 );

        long startTime = response.extract().jsonPath().getLong( "bingoLobbyInfoResource.streams[6].startTime" );
        assertThat( startTime ).isGreaterThanOrEqualTo( 1627415700000L );

        System.out.println( "Start time is :  " + startTime );


    }


}

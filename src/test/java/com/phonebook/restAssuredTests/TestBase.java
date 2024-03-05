package com.phonebook.restAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidGFsaWE5OEBnbXguZGUiLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcwOTkyMTE5NCwiaWF0IjoxNzA5MzIxMTk0fQ.Mw7j3d7u0vshI3vPf6oJDLDy1q5F0aCYeoicPyEcfI4";

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }
}




















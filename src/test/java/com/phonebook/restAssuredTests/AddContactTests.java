package com.phonebook.restAssuredTests;

import com.phonebook.dto.ContactDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class AddContactTests extends TestBase{
    @Test
    public void addContactSuccessTest() {
        ContactDto contactDto = ContactDto.builder()
                .name("Olivia")
                .lastName("König")
                .phone("1234567890")
                .email("keun@gm.com")
                .address("Berlin")
                .description("goalkeeper")
                .build();

        String message = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(contactDto)
                .post("contacts")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body(containsString("Contact was added!"))
                .extract().path("message");
        //System.out.println(message);
    }
}



















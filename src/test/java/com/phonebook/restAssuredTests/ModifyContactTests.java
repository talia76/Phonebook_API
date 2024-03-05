package com.phonebook.restAssuredTests;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.MessageDto;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ModifyContactTests extends TestBase{
    String id;

    @BeforeMethod
    public void precondition() {
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
        String[] all = message.split(": ");
        id = all[1];
    }
    @Test
    public void modifySuccessTest(){
        MessageDto messageDto = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(ContactDto.builder()
                        .id(id)
                        .name("Olivia")
                        .lastName("König")
                        .phone("1234567890")
                        .email("keun@gm.com")
                        .address("Berlin")
                        .description("goalkeeper")
                        .build())
                .when()
                .put("contacts")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message", equalTo("Contact was updated"))
                .extract().response().as(MessageDto.class);
        //System.out.println(messageDto);
    }
}



















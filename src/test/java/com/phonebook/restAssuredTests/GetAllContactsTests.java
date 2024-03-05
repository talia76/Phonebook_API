package com.phonebook.restAssuredTests;

import com.phonebook.dto.AllContactDto;
import com.phonebook.dto.ContactDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllContactsTests extends TestBase{
    @Test
    public void getAllContactSuccessTest() {
        AllContactDto responseDto = given()
                .header("Authorization", token)
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactDto.class);

        for (ContactDto contact: responseDto.getContacts()) {
            System.out.println(contact.getId() + "***" + contact.getName() + "****");
            System.out.println("================================================");

        }
    }

}



















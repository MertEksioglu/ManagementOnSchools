package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;

import java.util.List;
import java.util.Objects;

import static base_urls.ManagementonSchoolBaseUrl.setUp;
import static base_urls.ManagementonSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_01_API_RegistrationStepDefs {
    Response response;

    @Given("Send get request by username {string}")
    public void sendGetRequestByUsername(String username) {
        //Set the url
        //https://managementonschools.com/app/guestUser/getAll?size=10000
        spec.pathParams("first", "guestUser", "second", "getAll").queryParam("size", "10000");

        //Set the expected data

        //Send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();
    }

    @Then("body should contain birth_day {string}, birth_place {string}, gender {string}, name {string}, phone_number {string}, ssn {string}, surname {string}, username {string}")
    public void body_should_contain_birth_day_birth_place_gender_name_phone_number_ssn_surname_username(String birth_day, String birth_place, String gender, String name, String phone_number, String ssn, String surname, String username) {
        // Assert
        JsonPath jsonPath = response.jsonPath();

        String actBirthDay = jsonPath.getList("content.findAll{it.username=='" + username + "'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("content.findAll{it.username=='" + username + "'}.birthPlace").get(0).toString();
        String actGender = jsonPath.getList("content.findAll{it.username=='" + username + "'}.gender").get(0).toString();
        String actName = jsonPath.getList("content.findAll{it.username=='" + username + "'}.name").get(0).toString();
        String actPhoneNumber = jsonPath.getList("content.findAll{it.username=='" + username + "'}.phoneNumber").get(0).toString();
        String actSsn = jsonPath.getList("content.findAll{it.username=='" + username + "'}.ssn").get(0).toString();
        String actSurname = jsonPath.getList("content.findAll{it.username=='" + username + "'}.surname").get(0).toString();
        String actUsername = jsonPath.getList("content.findAll{it.username=='" + username + "'}.username").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals(birth_day, actBirthDay);
        assertEquals(birth_place, actBirthPlace);
        assertEquals(gender, actGender);
        assertEquals(name, actName);
        assertEquals(phone_number, actPhoneNumber);
        assertEquals(ssn, actSsn);
        assertEquals(surname, actSurname);
        assertEquals(username, actUsername);

    }

    @Then("Body must be empty with non-existing username {string}")
    public void bodyMustBeEmptyWithNonExistingUsername(String username) {
        List<Objects> dataList = response.jsonPath().getList("content.findAll{it.username=='" + username + "'}");
        TestCase.assertTrue(dataList.isEmpty());
    }
}
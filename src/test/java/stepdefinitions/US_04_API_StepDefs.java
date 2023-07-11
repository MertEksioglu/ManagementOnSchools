package stepdefinitions;

import base_urls.ManagementonSchoolBaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;


public class US_04_API_StepDefs extends ManagementonSchoolBaseUrl {
    Response response;


    @Given("send the request by {string}")
    public void send_the_request_by(String username) {

        //Set the url
        //https://managementonschools.com/app/dean/getAll
        setUp();
        spec.pathParams("first","dean","second","getManagerById" , "third",540);
//


        //Send the request and get the response
        response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Given("body should contains birth_day {string} , birth_place {string} , gender {string} , name {string}, phone_number {string}, ssn {string}, surname {string}")
    public void body_should_contains_birth_day_birth_place_gender_name_phone_number_ssn_surname(String birth_day, String birth_place, String gender, String name, String phone_number, String ssn, String surname) {

        //Do assertion

        response.
                then().
                statusCode(200)
                .body("object.username", equalTo("DeanAlexx"),
                        "object.name",equalTo("Jhonson"),
                        "object.surname",equalTo("Brows"),
                        "object.birthDay",equalTo("1978-11-10"),
                        "object.ssn",equalTo("421-45-8563"),
                        "object.birthPlace", equalTo("France"),
                        "object.phoneNumber", equalTo("526-865-5854"),
                        "object.gender", equalTo("MALE"));


}
}



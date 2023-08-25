package stepdefinitions;

import base_urls.ManagementonSchoolBaseUrl;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import us16_test_data.JsonUtil;
import us16_test_data.US14Testdata;


import java.util.Map;

import static io.restassured.RestAssured.given;
@JsonIgnoreProperties(ignoreUnknown = true)
public class US_14_APIStepDefs extends ManagementonSchoolBaseUrl {
    Response response;


    @And("user sends put request with id {int} to get response")
    public void userSendsPutRequestWithIdToGetResponse(int userId) {
        setUpViceDean();
        JsonUtil jsonUtil = new JsonUtil();

        spec2.pathParams("first","teachers","second", "update", "Third", userId);

        US14Testdata us14Testdata = new US14Testdata();

        Map<String,String> expectedData = us14Testdata.teacherUsersSetUp("loan.feil","12345678",
                "5", "Ahmad12", "Mahmood", "1984-06-22", "100-97-9876", "Madrid",
                "111-234-5674", "MALE", "ollie.conroy@hotmail.com");
        System.out.println(expectedData);



        response = given().spec(spec2).body(expectedData).contentType(ContentType.JSON).when().put("/{first}/{second}/{Third}");
        response.prettyPrint();
    }
}



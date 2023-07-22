package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static junit.framework.TestCase.assertEquals;

public class US_21_DB_RegistrationStepDefs {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    ResultSet resultSet2;

    @Given("connect to school database")
    public void connect_to_database() throws SQLException {

        //Create connection
        connection =  DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user","43w5ijfso");
        //Create Statement
        statement = connection.createStatement();

    }

    @Then("get student_id via username {string}")
    public void getStudent_idViaUsername(String username) throws SQLException {
        //Create ResultSet
        String SqlQuery = "SELECT id FROM \"public\".student WHERE username = '"+username+"'";
        resultSet = statement.executeQuery(SqlQuery);
    }

//    @Then("get guest_user via name {string}")
//    public void get_dean_via_name(String name) throws SQLException {
//
//        //Create ResultSet
//        String sqlQuery = "SELECT * FROM \"public\".guest_user WHERE name = '"+name+"'";
//        resultSet = statement.executeQuery(sqlQuery);
//
//
//    }

    @Then("get student_info via username {string}")
    public void getStudent_infoViaStudent_id(String username) throws SQLException {
        //Create ResultSet
        String studentinfoSqlQuery = "SELECT * FROM \"public\".student_info WHERE student_info.student_id = (SELECT id FROM \"public\".student WHERE username = '"+username+"')";
        resultSet = statement.executeQuery(studentinfoSqlQuery);
    }

    @And("body contains id {string}, absentee {string}, midterm_exam {string}, final_exam {string}, letter_grade {string}, info_note {string}, exam_average {string}")
    public void bodyContainsLesson_nameAbsenteeMidterm_examFinal_examLetter_gradeInfo_noteExam_average(String id, String absentee, String midterm_exam, String final_exam, String letter_grade, String info_note, String exam_average) throws SQLException {

        resultSet.next();

        String actid = resultSet.getString("id");
        String actAbsentee = resultSet.getString("absentee");
        String actMidterm_exam = resultSet.getString("midterm_exam");
        String actFinal_exam = resultSet.getString("final_exam");
        String actLetter_grade = resultSet.getString("letter_grade");
        String actInfo_note = resultSet.getString("info_note");
        String actExam_average = resultSet.getString("exam_average");

        assertEquals(id,actid);
        assertEquals(absentee,actAbsentee);
        assertEquals(midterm_exam,actMidterm_exam);
        assertEquals(final_exam,actFinal_exam);
        assertEquals(letter_grade,actLetter_grade);
        assertEquals(info_note,actInfo_note);
        assertEquals(exam_average,actExam_average);
    }


    @Then("see lesson_name {string} via id {string}")
    public void seeLesson_nameViaId(String lesson_name, String id) throws SQLException {

        //Create ResultSet
        String SqlQuery = "select lesson_name from \"public\".lesson where lesson.lesson_id = '"+id+"';";
        resultSet2 = statement.executeQuery(SqlQuery);

        resultSet2.next();

        String actlesson_name = resultSet2.getString("lesson_name");
        assertEquals(lesson_name,actlesson_name);
    }

    @Then("get advisor_teacher_id via username {string}")
    public void getAdvisor_teacher_idViaUsername(String arg0) {
        
    }

    @Then("get student meeting info via advisor_teacher_id {string}")
    public void getStudentMeetingInfoViaAdvisor_teacher_id(String arg0) {
        
    }

    @And("the body contains date {string} , start_time {string} , stop_time {string} , description {string}")
    public void theBodyContainsDateStart_timeStop_timeDescription(String arg0, String arg1, String arg2, String arg3) {
    }
}

// select lesson_name from "public".lesson where lesson.lesson_id = '2';
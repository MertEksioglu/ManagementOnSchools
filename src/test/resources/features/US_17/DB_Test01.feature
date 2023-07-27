@US_17_DB_TC_01
Feature: Teacher should be able to see student information

  Scenario Outline: US17_GetStudentInfo

    Given get student info via to id "<id>"
    Then body contains exam_average "<exam_average>" , final_exam "<final_exam>", info_note "<info_note>", letter_grade "<letter_grade>", midterm_exam "<midterm_exam>" , education_term_id "<education_term_id>", lesson_lesson_id "<lesson_lesson_id>", student_id "<student_id>", teacher_id "<teacher_id>"
    Examples:
      | id  | exam_average | final_exam | info_note  | letter_grade | midterm_exam | education_term_id | lesson_lesson_id | student_id | teacher_id |
      | 889 | 90           | 90         | successful | AA           | 90           | 1                 | 2                | 6          | 874        |
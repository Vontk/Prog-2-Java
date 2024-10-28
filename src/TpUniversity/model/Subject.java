package TpUniversity.model;

import TpUniversity.model.Evaluations.Evaluation;

import java.util.List;

public class Subject extends Entity  {
    // Classroom,Subject,Student_Name,Student_Email,Subject_Teacher
    // Student,Subject,Evaluation_Type,Evaluation_Name,Exercise_Name,Grade
    List<Teacher> teachers;
    List<Evaluation> evaluations;
    List<Student> students;
    List<Classroom> classrooms;
}

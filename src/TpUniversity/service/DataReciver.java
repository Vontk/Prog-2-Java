package TpUniversity.service;

import TpUniversity.model.*;
import TpUniversity.model.Evaluations.Evaluation;

import static TpUniversity.service.EntityManager.*;

public class DataReciver {

    public static void firstDataPoint(String classroomID,String subjectName, String studentName,
                                      String studentEmail, String subjectTeacher){
        // instance or get model objects

        Teacher teacher = newTeacher(subjectTeacher);
        Student student = newStudent(studentName);
        Classroom classroom = newClassroom(classroomID);
        Subject subject = newSubject(subjectName);

        // associate possible links between objects

        teacher.addClassroom(classroom);
        teacher.addSubject(subject);
        teacher.addStudent(student);

        student.addSubject(subject);
        student.setEmail(studentEmail);

        classroom.addTeacher(teacher);
        classroom.addStudent(student);
        classroom.addSubject(subject);

        subject.addTeacher(teacher);
        subject.addStudent(student);
        subject.addClassroom(classroom);

    }

    public static void secondDataPoint(String studentName, String subjectName, String evaluationType,
                                       String evaluationName, String exerciseName, String grade){

        Student student = newStudent(studentName);
        Subject subject = newSubject(subjectName);
        Evaluation evaluation = newEvaluation(evaluationName, subjectName, studentName, evaluationType);
        Exercise exercise = newExercise(exerciseName, Double.parseDouble(grade), evaluation);

        student.addSubject(subject);

        subject.addStudent(student);

    }
}

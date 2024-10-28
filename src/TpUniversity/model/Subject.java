package TpUniversity.model;

import TpUniversity.model.Evaluations.Evaluation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subject extends Entity  {
    // Classroom,Subject,Student_Name,Student_Email,Subject_Teacher
    // Student,Subject,Evaluation_Type,Evaluation_Name,Exercise_Name,Grade

    String name;
    HashSet<Teacher> teachers;
    HashSet<Student> students;
    HashSet<Classroom> classrooms;

    public Subject(String name) {
        this.name = name;
        this.teachers = new HashSet<>();
        this.students = new HashSet<>();
        this.classrooms = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public String getName() {
        return name;
    }
}

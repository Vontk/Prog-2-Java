package TpUniversity.service;

import TpUniversity.model.*;
import TpUniversity.model.Evaluations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// This class is responsible for managing the entities of the system,
// it provides methods to create new instances of these entities, ensure they are unique,
// and store them in collections for easy access. Each entity has a unique ID.


public class EntityManager {

    public static Map<Integer, Entity> entities = new HashMap<>();

    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Evaluation> evaluations = new ArrayList<>();
    public static ArrayList<Exercise> exercises = new ArrayList<>();
    public static ArrayList<Subject> subjects = new ArrayList<>();
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    public static ArrayList<Classroom> classes = new ArrayList<>();

    // Alternative ID method (mas prolijo):

    // private int newId() {
    //     return entities.size() + 1;
    // }

    // Map<Int; uniqueID, Entity; Entity>
    public static void addEntity(Entity entity) {
        entities.put(entity.getId(), entity);
    }

    // generates a unique ID for each entity
    public static int newId() {
        int newId = (int) (Math.random() * 100000000);
        while (entities.containsKey(newId)) {
            newId = (int) (Math.random() * 100000000);
        }
        return newId;
    }

    public static Student newStudent(String studentName) {

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }

        Student newStudent = new Student(studentName);
        students.add(newStudent);
        newStudent.setId(newId());
        addEntity(newStudent);
        return newStudent;

    }

    public static Evaluation newEvaluation(String evaluationName, String subjectName, String studentName, String evaluationType) {

        for (Evaluation evaluation : evaluations) {
            if (evaluation.getName().equals(evaluationName) && evaluation.getSubject().equals(subjectName) && evaluation.getStudentName().equals(studentName)) {
                return evaluation;
            }
        }

        Evaluation newEvaluation = switch (evaluationType) {
            case "WRITTEN_EXAM" -> new WrittenExam(evaluationName, subjectName, studentName);
            case "PRACTICAL_WORK" ->  new PracticalWork(evaluationName, subjectName, studentName);
            case "FINAL_PRACTICAL_WORK" -> new FinalPracticalWork(evaluationName, subjectName, studentName);
            case "ORAL_EXAM" -> new OralExam(evaluationName, subjectName, studentName);
            default -> throw new IllegalStateException("Unexpected value: " + evaluationType);
        };

        evaluations.add(newEvaluation);
        newEvaluation.setId(newId());
        addEntity(newEvaluation);
        return newEvaluation;
    }

    public static Exercise newExercise(String name, double grade, Evaluation evaluation) {

        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getGrade() == grade && exercise.getEvaluation().equals(evaluation)) {
                return exercise;
            }
        }

        Exercise newExercise = new Exercise(name, grade, evaluation);
        exercises.add(newExercise);
        newExercise.setId(newId());
        addEntity(newExercise);
        return newExercise;
    }

    public static Subject newSubject(String subjectName) {

        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject;
            }
        }

        Subject newSubject = new Subject(subjectName);
        subjects.add(newSubject);
        newSubject.setId(newId());
        addEntity(newSubject);
        return newSubject;
    }

    public static Teacher newTeacher(String teacherName) {

        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(teacherName)) {
                return teacher;
            }
        }

        Teacher newTeacher = new Teacher(teacherName);
        teachers.add(newTeacher);
        newTeacher.setId(newId());
        addEntity(newTeacher);
        return newTeacher;
    }

    public static Classroom newClassroom(String classroomId) {

        for (Classroom classroom : classes) {
            if (classroom.getClassroomId() == Integer.parseInt(classroomId)) {
                return classroom;
            }
        }

        Classroom newClassroom = new Classroom(Integer.parseInt(classroomId));
        classes.add(newClassroom);
        newClassroom.setId(newId());
        addEntity(newClassroom);
        return newClassroom;
    }

    public static void firstDataPoint(String classroomID,String subjectName, String studentName,
                                      String studentEmail, String subjectTeacher){
        // instance or get model objects

        Teacher teacher = newTeacher(subjectTeacher);
        Student student = newStudent(studentName);
        Classroom classroom = newClassroom(classroomID);
        Subject subject = newSubject(subjectName);

        // Associate all possible relationships with given data

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

        evaluation.addExercise(exercise);
        evaluation.setEvaluationType(evaluationType);
    }
}

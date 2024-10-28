package TpUniversity.service;

import TpUniversity.model.*;
import TpUniversity.model.Evaluations.Evaluation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManager {

    public static Map<Integer, Entity> entities = new HashMap<>();

    public static List<Student> students;
    public static List<Evaluation> evaluations;
    public static List<Exercise> exercises;
    public static List<Subject> subjects;
    public static List<Teacher> teachers;
    public static List<Classroom> classes;

    public static void addEntity(Entity entity) {
        entities.put(entity.getId(), entity);
    }

    public static void addStudent(Student student) {
        students.add(student);
        addEntity(student);
    }

    public static void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
        addEntity(evaluation);
    }

    public static void addExercise(Exercise exercise) {
        exercises.add(exercise);
        addEntity(exercise);
    }

    public static void addSubject(Subject subject) {
        subjects.add(subject);
        addEntity(subject);
    }

    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        addEntity(teacher);
    }

    public static void addClass(Classroom classroom) {
        classes.add(classroom);
        addEntity(classroom);
    }

}

package TpUniversity.service;
import TpUniversity.inOut.Box;
import TpUniversity.model.*;
import TpUniversity.model.Evaluations.*;
import TpUniversity.service.EvaluationCriteriaManager.*;

import java.util.*;

public class UniversityManager {

    public List<String[]> firstTaskLogic(List<String[]> inputData) {

        // se recorre el csv y se agregan todos los estudiantes con sus cursos
        for (String[] strings : inputData) {

            String subjectTeacher = strings[4];
            String studentEmail = strings[3];
            String studentName = strings[2];
            String subject = strings[1];
            String classroom = strings[0];

            DataReciver.firstDataPoint(classroom, subject, studentName, studentEmail, subjectTeacher);
        }

        List<String[]> outputData = new ArrayList<>();

        // se recorre la lista de estudiantes y se construye un arreglo para cada elemento de la lista
        // cada par de datos tiene nombre y cantidad de cursos, como indica el haeader.

        ArrayList<Student> students = EntityManager.students;

        for (Student student : students) {
            outputData.add(student.getFirstTaskPrintData());
        }

        // se ordena en orden aflabetico, compara el elemento 0 de los arreglos de la lista
        outputData.sort(Comparator.comparing(array -> array[0]));
        // se agrega el header
        String[] header = {"Student_Name","Course_Count"};
        outputData.addFirst(header);
        return outputData;
    }

    public Box<List<String[]>, List<Evaluation>> secondTaskLogic(List<String[]> inputData) {

        // se obtiene la lista de evaluaciones
        ArrayList<Evaluation> evaluations = EntityManager.evaluations;

        // se recorre el csv y se agregan todas las evaluaciones con sus notas, tipo de evaluacion, y los objetos
        // relacionados; la materia, ejercicio y estudiante asociados(as).
        for (String[] strings : inputData) {

            String studentName = strings[0];
            String subject = strings[1];
            String evaluationType = strings[2];
            String evaluationName = strings[3];
            String exerciseName = strings[4];
            String grade = strings[5];

            DataReciver.secondDataPoint(studentName, subject, evaluationType, evaluationName, exerciseName, grade);

        }

        List<String[]> output = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            // getPrintData es un metodo que retorna un String[] con los datos de la evaluacion, ordenados como exige el expected
            String[] line = evaluation.getSecondTaskPrintData();
            output.add(line);
        }

        // Sort by Subject_Name, then Evaluation_Name, and finally Student_Name
        output.sort(Comparator.comparing((String[] array) -> array[0])  // Sort by Subject_Name
                .thenComparing(array -> array[1])                       // Then by Evaluation_Name
                .thenComparing(array -> array[2]));                     // Then by Student_Name

        String[] header = {"Subject_Name","Evaluation_Name","Student_Name", "Grade"};
        output.addFirst(header);
        // Box is a class to return two variables
        return new Box<>(output, evaluations);
    }
    public List<String[]> thirdTaskLogic(List<String[]> input_3csv, Box<List<String[]>, List<Evaluation>> processedData) {

        List<String[]> outputData = new ArrayList<>();                // objective return
        List<Evaluation> evaluations = processedData.getSecond(); // retriving variables from Box object

        for (String[] EvaluationCriteriaAndSubject : input_3csv) {

            for (Evaluation evaluation : evaluations) {
                if (evaluation.isEvaluated()) {continue;}

                //EvaluationCriteriaAndSubject; {Subject_Name,Criteria_Type,Criteria_Value,Evaluation_Name_1, Evaluation_Name_2, ...}
                for (int k = 3; k < EvaluationCriteriaAndSubject.length; k++) { // index 3 to end are evaluation

                    String evaluationName = EvaluationCriteriaAndSubject[k];
                    String subjectName = EvaluationCriteriaAndSubject[0];

                    if (evaluationName.equals(evaluation.getEvaluationName())
                        && subjectName.equals(evaluation.getSubject())) { // evaluation match condition

                        String criteriaType = EvaluationCriteriaAndSubject[1];
                        String criteriaValue = EvaluationCriteriaAndSubject[2];

                        EvaluationCriteria criteria = switch (criteriaType) {
                            case "AVERAGE_ABOVE_VALUE" -> new AverageAboveValue();
                            case "MIN_ABOVE_VALUE" -> new MinAboveValue();
                            case "MAX_ABOVE_VALUE" -> new MaxAboveValue();
                            default -> throw new IllegalStateException("Unexpected value: " + criteriaType);
                        };
                        criteria.apply(evaluation, Double.parseDouble(criteriaValue), criteriaType);
                    }
                }
            }
        }

        for (Evaluation evaluation : evaluations) {
            outputData.add(evaluation.getThirdTaskPrintData());
        }

        String[] header = {"Evaluation_Name","Student_Name","Evaluation_Type","Criteria","Criteria_Value","Grade","Passed","Min","Max","Average","Subject_Name"};
        outputData.addFirst(header);

        return outputData;
    }
}


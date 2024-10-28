package TpUniversity.service;
import TpUniversity.inOut.Box;
import TpUniversity.model.*;
import TpUniversity.model.Evaluations.*;
import TpUniversity.service.EvaluationCriteriaManager.*;

import java.util.*;

public class UniversityManager {

    public List<String[]> firstTaskLogic(List<String[]> inputData) {

        ArrayList<Student> students = EntityManager.students;

        // se recorre el csv y se agregan todos los estudiantes con sus cursos
        for (String[] strings : inputData) {

            String subjectTeacher = strings[4];
            String studentEmail = strings[3];
            String studentName = strings[2];
            String subject = strings[1];
            String classroom = strings[0];

            EntityManager.firstDataPoint(classroom, subject, studentName, studentEmail, subjectTeacher);
        }

        List<String[]> outputData = new ArrayList<>();

        // se recorre la lista de estudiantes y se construye un arreglo para cada elemento de la lista
        // cada par de datos tiene nombre y cantidad de cursos

        for (Student student : students) {
            String[] line = {student.getName(), String.valueOf(student.getSubjectAmount())};
            outputData.add(line);
        }

        // se ordena en orden aflabetico, compara el elemento 0 de los arreglos de la lista
        outputData.sort(Comparator.comparing(array -> array[0]));
        // se agrega el header
        String[] header = {"Student_Name","Course_Count"};
        outputData.addFirst(header);
        return outputData;
    }

    public Box<List<String[]>, List<Evaluation>> secondTaskLogic(List<String[]> inputData) {
        ArrayList<Evaluation> evaluations = new ArrayList<>();
        for (String[] strings : inputData) {

            String studentName = strings[0];
            String subject = strings[1];
            String evaluationType = strings[2];
            String evaluationName = strings[3];
            String exerciseName = strings[4];
            String grade = strings[5];

            EntityManager.secondDataPoint(studentName, subject, evaluationType, evaluationName, exerciseName, grade);


        }

        evaluations.sort(Comparator.comparing(Evaluation::getName)
                .thenComparing(Evaluation::getEvaluationName)
                .thenComparing(Evaluation::getSubject));

        List<String[]> output = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            String[] line = evaluation.getData();
            output.add(line);
        }

// Sort by Subject_Name, then Evaluation_Name, and finally Student_Name
        output.sort(Comparator.comparing((String[] array) -> array[0])  // Sort by Subject_Name
                .thenComparing(array -> array[1])                       // Then by Evaluation_Name
                .thenComparing(array -> array[2]));                     // Then by Student_Name
        // Sort the list for later use
        evaluations.sort(Comparator.comparing(Evaluation::getSubject)
                .thenComparing(Evaluation::getEvaluationName)
                .thenComparing(Evaluation::getStudentName));

        String[] header = {"Subject_Name","Evaluation_Name","Student_Name", "Grade"};
        output.addFirst(header);
        // Box is a class to return two variables
        return new Box<>(output, evaluations);
    }
    public List<String[]> thirdTaskLogic(List<String[]> inputOf3List, Box<List<String[]>, List<Evaluation>> processedData) {

        List<String[]> outputData = new ArrayList<>();                // objective return
        List<Evaluation> evaluationsList = processedData.getSecond(); // retriving variables from Box object
        String[] inputOf3Row;                                         // declaration of array variavbles

        Map<String, EvaluationCriteria> criteriaMap = new HashMap<>();// map to sort criteria
        criteriaMap.put("AVERAGE_ABOVE_VALUE", new AverageAboveValue());
        criteriaMap.put("MAX_ABOVE_VALUE", new MaxAboveValue());
        criteriaMap.put("MIN_ABOVE_VALUE", new MinAboveValue());

        for (String[] strings : inputOf3List) { // i es el index de el input, con los datos para evaluar

            inputOf3Row = strings;

            for (Evaluation evaluation : evaluationsList) { // j es el index de las evaluaciones
                if (evaluation.isEvaluated()) {
                    continue;
                }
                for (int k = 3; k < inputOf3Row.length; k++) { // k es el index de los tipos de evaluaciones

                    //items in array; Subject_Name,Criteria_Type,Criteria_Value,Evaluation_Name

                    if (inputOf3Row[k].equals(evaluation.getEvaluationName())) { // found evaluation

                        String criteriaType = inputOf3Row[1];
                        String criteriaValue = inputOf3Row[2];

                        EvaluationCriteria criteria = criteriaMap.get(criteriaType);

                        criteria.apply(evaluation, Double.parseDouble(criteriaValue), criteriaType);
                    }
                }

            }
        }
        for (Evaluation evaluation : evaluationsList) {
            String[] line = evaluation.getAltData();
            outputData.add(line);
        }
        // Sort by Subject_Name, then Evaluation_Name, and finally Student_Name
        outputData.sort(Comparator.comparing((String[] array) -> array[0])  // Sort by Subject_Name
                .thenComparing(array -> array[1])                           // Then by Evaluation_Name
                .thenComparing(array -> array[2]));                         // Then by Student_Name

        String[] header = {"Subject_Name","Evaluation_Name","Student_Name","Evaluation_Type","Grade","Criteria","Criteria_Value","Passed","Min","Max"};
        outputData.addFirst(header);
        return outputData;
    }
}


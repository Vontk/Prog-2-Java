package TpUniversity.service;
import TpUniversity.inOut.Box;
import TpUniversity.model.*;
import TpUniversity.model.Evaluations.*;
import TpUniversity.service.CriteriaAnalyzer.*;

import java.util.*;


public class ReportGenerator {

    public List<String[]> firstReport(List<String[]> inputData) {
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
        String[] header = {"Student_Name","Course_Count"};
        outputData.addFirst(header);
        return outputData;
    }

    public List<String[]> secondReport(List<String[]> inputData) {

        for (String[] strings : inputData) {
            DataReciver.secondDataPoint(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
        }

        ArrayList<Evaluation> evaluations = EntityManager.evaluations;

        List<String[]> output = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            String[] line = evaluation.getSecondTaskPrintData();
            output.add(line);
        }

        output.sort(Comparator.comparing((String[] array) -> array[0])  // Sort by Subject_Name
                .thenComparing(array -> array[1])                       // Then by Evaluation_Name
                .thenComparing(array -> array[2]));                     // Then by Student_Name

        String[] header = {"Subject_Name","Evaluation_Name","Student_Name", "Grade"};
        output.addFirst(header);

        return output;
    }
    public List<String[]> thirdReport(List<String[]> input_3csv) {

        List<Evaluation>  evaluations = EntityManager.evaluations;
        for (String[] thirdInputLine : input_3csv) {
            DataReciver.thirdDataPoint(thirdInputLine);
        }

        List<String[]> outputData = new ArrayList<>();

        for (Evaluation evaluation : evaluations) {
            outputData.add(evaluation.getThirdTaskPrintData());
        }

        String[] header = {"Evaluation_Name","Student_Name","Evaluation_Type","Criteria","Criteria_Value","Grade","Passed","Min","Max","Average","Subject_Name"};
        outputData.addFirst(header);

        return outputData;
    }
}


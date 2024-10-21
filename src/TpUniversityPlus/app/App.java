package TpUniversityPlus.app;

import TpUniversityPlus.inOut.*;
import TpUniversityPlus.service.StudentManager;

import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.task1();
        app.task2();
    }

    public void task1() {
        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        StudentManager manager = new StudentManager();

        List<String[]> inputData = reader.readCSV("src/TpUniversity/input.csv");
        manager.processCourses(inputData);

        List<String[]> outputData = manager.getCourseCountData();
        writer.writeCSV("src/TpUniversity/solution.csv", outputData);
    }

    public void task2() {
        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        StudentManager manager = new StudentManager();

        List<String[]> inputData = reader.readCSV("src/TpUniversity/input_2.csv");
        manager.processEvaluations(inputData);

        List<String[]> outputData = manager.getEvaluationsData();
        writer.writeCSV("src/TpUniversity/solution_2.csv", outputData);
    }
}

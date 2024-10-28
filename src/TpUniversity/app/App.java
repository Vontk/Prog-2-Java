package TpUniversity.app;

import TpUniversity.inOut.*;
import TpUniversity.model.Evaluations.Evaluation;
import TpUniversity.inOut.Box;
import TpUniversity.service.UniversityManager;

import java.util.List;

public class App {
    // Object used on task2 to return multiple return variables
    Box<List<String[]>, List<Evaluation>> processedData;

    public static void main(String[] args) {
        App app = new App();
        app.task1();
        app.task2();
        app.task3();
    }

    public void task1() {
        CSVManager csvManager = new CSVManager();
        UniversityManager manager = new UniversityManager();

        List<String[]> inputData = csvManager.read("src/TpUniversity/csvFiles/input.csv");
        List<String[]> outputData = manager.firstTaskLogic(inputData);
        csvManager.write("src/TpUniversity/csvFiles/solution.csv", outputData);
    }

    public void task2() {
        CSVManager csvManager = new CSVManager();
        UniversityManager manager = new UniversityManager();

        List<String[]> inputData = csvManager.read("src/TpUniversity/csvFiles/input_2.csv");
        this.processedData = manager.secondTaskLogic(inputData);
        csvManager.write("src/TpUniversity/csvFiles/solution_2.csv", processedData.getFirst());

    }

    public void task3() {
        CSVManager csvManager = new CSVManager();
        UniversityManager manager = new UniversityManager();

        List<String[]> inputData = csvManager.read("src/TpUniversity/csvFiles/input_3.csv");
        List<String[]> outputData = manager.thirdTaskLogic(inputData, processedData);
        csvManager.write("src/TpUniversity/csvFiles/solution_3.csv", outputData);
    }
}

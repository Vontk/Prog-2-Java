package TpUniversity.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniversityManagerTest {

    UniversityManager manager;

    @BeforeEach
    public void setUp() {
        manager = new UniversityManager();
    }

    @Test
    public void testFirstTaskLogic() {
        // Sample input data (CSV format): Student_Name, Course
        List<String[]> inputData = new ArrayList<>();
        inputData.add(new String[]{"John", "Math", "John Doe"});
        inputData.add(new String[]{"John", "Science", "John Doe"});
        inputData.add(new String[]{"Jane", "History", "Jane Roe"});
        inputData.add(new String[]{"Jane", "Math", "Jane Roe"});

        // Run the logic
        List<String[]> outputData = manager.firstTaskLogic(inputData);

        // Output the results for visual validation (optional)
        System.out.println("Test FirstTaskLogic:");
        for (String[] line : outputData) {
            System.out.println(String.join(", ", line));
        }

        // Validate the results
        assertEquals("Jane Roe", outputData.get(1)[0], "Student Jane should be first after sorting");
        assertEquals("2", outputData.get(1)[1], "Jane should have 2 courses");

        assertEquals("John Doe", outputData.get(2)[0], "Student John should be second after sorting");
        assertEquals("2", outputData.get(2)[1], "John should have 2 courses");
    }

    @Test
    public void testSecondTaskLogic() {
        // Sample input data (CSV format): Student_Name, Subject, ..., Evaluation_Name, ..., Grade
        List<String[]> inputData = new ArrayList<>();
        inputData.add(new String[]{"John Doe", "Math", "", "Exam 1", "", "85"});
        inputData.add(new String[]{"Pepito Aurelio", "Math", "", "Exam 1", "", "90"});
        inputData.add(new String[]{"John Doe", "Science", "", "Exam 2", "", "78"});
        inputData.add(new String[]{"Pepito Aurelio", "Science", "", "Exam 2", "", "88"});
        inputData.add(new String[]{"John Doe", "Math", "", "Exam 1", "", "95"});

        // Run the logic
        List<String[]> outputData = manager.secondTaskLogic(inputData);

        // Output the results for visual validation (optional)
        System.out.println("\nTest SecondTaskLogic:");
        for (String[] line : outputData) {
            System.out.println(String.join(", ", line));
        }

        // Validate the results
        assertEquals("Math", outputData.get(1)[0], "First subject should be Math");
        assertEquals("Exam 1", outputData.get(1)[1], "First evaluation should be Exam 1");
        assertEquals("Jane Roe", outputData.get(1)[2], "Jane Roe should be listed first for Math Exam 1");
        assertEquals("90.0", outputData.get(1)[3], "Jane Roe's average grade should be 90.0 for Math Exam 1");

        assertEquals("John Doe", outputData.get(2)[2], "John Doe should be listed after Jane Roe for Math Exam 1");
        assertEquals("90.0", outputData.get(2)[3], "John Doe's average grade should be 90.0 for Math Exam 1");
    }
}

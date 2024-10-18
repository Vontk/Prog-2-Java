package TpUniversity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;

class Student {
    HashSet<String> courses;
    String name;
    ArrayList<EvaluationLOL> evaluations;

    public Student(String name) {
        this.courses = new HashSet<>();
        this.name = name;
        this.evaluations = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void addCourse(String course) {
        courses.add(course);
    }
    
    void addEvaluation(EvaluationLOL evaluation) {
    evaluations.add(evaluation);
    }

    ArrayList<EvaluationLOL> getEvaluations(){
        return this.evaluations;
    }

    private int courseAmount() {
        return courses.size();
    }

    String[] getData() {
        return new String[]{this.getName(), String.valueOf(this.courseAmount())};
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentLOL student = (StudentLOL) obj;
        return name.equals(student.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
class Evaluation {

    ArrayList<Integer> grades;
    String evaluationName;
    String subject;
    String studentName;

    public Evaluation(String evaluationName, String subject, String studentName){
        this.grades = new ArrayList<>();
        this.evaluationName = evaluationName;
        this.subject = subject;
        this.studentName = studentName;
    }
    void addGrade(int grade){
        grades.add(grade);
    }
    float getAverage(){
        int sum = 0;
        for (Integer num : grades){
            sum += num;
        }
        return (float) sum / grades.size();
    }
    String getEvaluationName(){
        return this.evaluationName;
    }
    String getStudentName(){
        return this.studentName;
    }
    String getSubject(){
        return this.subject;
    }
    String[] getData(){
        //Subject_Name,Evaluation_Name,Student_Name,Grade (rounded to 1 decimal place)
        return new String[]{this.subject, this.evaluationName, this.studentName, String.format("%.1f",this.getAverage())};
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EvaluationLOL evaluation = (EvaluationLOL) obj;
        return evaluationName.equals(evaluation.evaluationName);
    }
    @Override
    public int hashCode() {
        return evaluationName.hashCode();
    }
}
    public class App {
        public static void main(String[] args) {
            String readFilePath = "src/TpUniversity/input.csv";
            String line;
            HashSet<StudentLOL> students = new HashSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(readFilePath))) {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");  // Splitting by comma
                    boolean studentFound = false;
                    for (StudentLOL student : students) {
                        if (student.getName().equals(values[2])) {
                            student.addCourse(values[1]);
                            studentFound = true;
                            break;
                        }
                    }
                    if (!studentFound) {
                        StudentLOL student = new StudentLOL(values[2]);
                        student.addCourse(values[1]);
                        students.add(student);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String writeFilePath = "src/TpUniversity/solution.csv";
            ArrayList<StudentLOL> studentsList = new ArrayList<>(students);
            studentsList.sort(Comparator.comparing(StudentLOL::getName));

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFilePath))) {
                String[] header = {"Student_Name", "Course_Count"};
                bw.write(String.join(",", header));
                bw.newLine();
                for (StudentLOL student : studentsList) {
                    String[] data = student.getData();
                    if (!data[0].equals("Student_Name")) {
                        bw.write(String.join(",", student.getData()));
                        bw.newLine();
                    }
                }
                bw.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // segunda parte del tp, basicamente repito lo mismo, le agrego un 2 a cada variable para distinguir
            String readFilePath2 = "src/TpUniversity/input_2.csv";
            HashSet<StudentLOL> students2 = new HashSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(readFilePath2))) {
                boolean firstLine = true; // Flag para la primera línea (encabezado)
                while ((line = br.readLine()) != null) {
                    if (firstLine) { // Ignora la primera línea (encabezado)
                        firstLine = false;
                        continue;
                    }
                    String[] values = line.split(",");  // Splitting by comma
                    boolean studentFound = false;
                    for (StudentLOL student : students2) {
                        if (student.getName().equals(values[0])) {
                            studentFound = true;
                            boolean evaluationExists = false;
                            for (EvaluationLOL evaluation : student.getEvaluations()){
                                if (evaluation.getEvaluationName().equals(values[3])){
                                    evaluation.addGrade(Integer.parseInt(values[5]));
                                    evaluationExists = true;
                                    break;
                                }
                            }
                            if (!evaluationExists){
                                EvaluationLOL evaluation = new EvaluationLOL(values[3], values[1], values[0]);
                                evaluation.addGrade(Integer.parseInt(values[5]));
                                student.addEvaluation(evaluation);
                            }
                        }
                    }
                    if (!studentFound){
                        StudentLOL student = new StudentLOL(values[0]);
                        EvaluationLOL evaluation = new EvaluationLOL(values[3], values[1], values[0]);
                        evaluation.addGrade(Integer.parseInt(values[5]));
                        student.addEvaluation(evaluation);
                        students2.add(student);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String writeFilePath2 = "src/TpUniversity/solution_2.csv";
            ArrayList<EvaluationLOL> evaluationList = new ArrayList<>();
            for (StudentLOL student : students2){
                evaluationList.addAll(student.getEvaluations());
            }

            evaluationList.sort(Comparator
                    .comparing(EvaluationLOL::getSubject)
                    .thenComparing(EvaluationLOL::getEvaluationName)
                    .thenComparing(EvaluationLOL::getStudentName));


            try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFilePath2))) {
                String[] header = {"Subject_Name", "Evaluation_Name", "Student_Name", "Grade"};
                bw.write(String.join(",", header));
                bw.newLine();
                for (EvaluationLOL evaluation : evaluationList) {
                    String[] data = evaluation.getData();
                    if (!data[0].equals("Subject_Name") && evaluationList.indexOf(evaluation)!= (evaluationList.size()-1) ) {
                        bw.write(String.join(",", data));
                        bw.newLine();
                    }
                    if (!data[0].equals("Subject_Name") && evaluationList.indexOf(evaluation) == (evaluationList.size()-1) ) {
                        bw.write(String.join(",", data));
                    }
                }
                bw.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

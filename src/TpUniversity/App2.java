package TpUniversity;

import java.io.*;
import java.util.*;

// Clase para representar un estudiante
class StudentLOL {
    HashSet<String> courses; // Conjunto de cursos en los que está inscrito el estudiante
    String name; // Nombre del estudiante
    ArrayList<EvaluationLOL> evaluations; // Lista de evaluaciones del estudiante

    public StudentLOL(String name) {
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

    ArrayList<EvaluationLOL> getEvaluations() {
        return this.evaluations;
    }

    // Devuelve la cantidad de cursos
    private int courseAmount() {
        return courses.size();
    }

    String[] getData() {
        return new String[] { this.getName(), String.valueOf(this.courseAmount()) };
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

// Clase para representar una evaluación
class EvaluationLOL {
    ArrayList<Integer> grades; // Lista de notas para la evaluación
    String evaluationName; // Nombre de la evaluación (ej. Parcial 1)
    String subject; // Nombre de la materia
    String studentName; // Nombre del estudiante

    public EvaluationLOL(String evaluationName, String subject, String studentName) {
        this.grades = new ArrayList<>();
        this.evaluationName = evaluationName;
        this.subject = subject;
        this.studentName = studentName;
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    // Calcula el promedio de las notas
    float getAverage() {
        int sum = 0;
        for (Integer num : grades) {
            sum += num;
        }
        return (float) sum / grades.size();
    }

    String getEvaluationName() {
        return this.evaluationName;
    }

    String getStudentName() {
        return this.studentName;
    }

    String getSubject() {
        return this.subject;
    }

    // Devuelve los datos de la evaluación en el formato correcto
    String[] getData() {
        return new String[] { this.subject, this.evaluationName, this.studentName, String.format("%.1f", this.getAverage()) };
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

public class App2 {
    public static void main(String[] args) {
        // Ruta del archivo de entrada
        String readFilePath = "src/TpUniversity/input_2.csv";
        String line;
        HashSet<StudentLOL> students = new HashSet<>(); // Conjunto de estudiantes
        try (BufferedReader br = new BufferedReader(new FileReader(readFilePath))) {
            boolean firstLine = true; // Flag para la primera línea (encabezado)
            while ((line = br.readLine()) != null) {
                if (firstLine) { // Ignora la primera línea (encabezado)
                    firstLine = false;
                    continue;
                }

                String[] values = line.split(","); // Dividir por comas
                String studentName = values[0];
                String subject = values[1];
                String evaluationName = values[3];
                int grade = Integer.parseInt(values[5]);

                // Busca al estudiante o lo crea si no existe
                StudentLOL student = students.stream()
                        .filter(s -> s.getName().equals(studentName))
                        .findFirst()
                        .orElse(new StudentLOL(studentName));

                // Busca la evaluación dentro de las evaluaciones del estudiante
                EvaluationLOL evaluation = student.getEvaluations().stream()
                        .filter(e -> e.getEvaluationName().equals(evaluationName))
                        .findFirst()
                        .orElse(new EvaluationLOL(evaluationName, subject, studentName));

                // Agrega la nota a la evaluación
                evaluation.addGrade(grade);

                // Si la evaluación es nueva, la agrega al estudiante
                if (!student.getEvaluations().contains(evaluation)) {
                    student.addEvaluation(evaluation);
                }

                // Si el estudiante es nuevo, lo agrega al conjunto
                if (!students.contains(student)) {
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Escribir la salida a un archivo CSV
        String writeFilePath = "src/TpUniversity/solution_2.csv";
        ArrayList<EvaluationLOL> evaluationList = new ArrayList<>();

        // Extraer todas las evaluaciones de cada estudiante
        for (StudentLOL student : students) {
            evaluationList.addAll(student.getEvaluations());
        }

        // Ordenar las evaluaciones por materia, nombre de la evaluación y nombre del estudiante
        evaluationList.sort(Comparator
                .comparing(EvaluationLOL::getSubject)
                .thenComparing(EvaluationLOL::getEvaluationName)
                .thenComparing(EvaluationLOL::getStudentName));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(writeFilePath))) {
            String[] header = { "Subject_Name", "Evaluation_Name", "Student_Name", "Grade" };
            bw.write(String.join(",", header));
            bw.newLine();

            for (EvaluationLOL evaluation : evaluationList) {
                String[] data = evaluation.getData();
                bw.write(String.join(",", data));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

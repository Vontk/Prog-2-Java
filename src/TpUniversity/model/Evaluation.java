package TpUniversity.model;

import java.util.ArrayList;

public class Evaluation {

    private ArrayList<Double> grades;
    ArrayList<String> exercises;
    String evaluationName;
    String subject;
    String studentName;
    String evaluationType;
    boolean passed;

    public Evaluation(String evaluationName, String subject, String studentName, String evaluationType) {
        this.grades = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.evaluationName = evaluationName;
        this.subject = subject;
        this.studentName = studentName;
        this.evaluationType = evaluationType;
    }

    public void addGrade(double grade){
        grades.add(grade);
    }

    public void addExercise(String exercise){
        exercises.add(exercise);
    }

    public double getAverage(){
        double sum = 0;
        for (Double num : grades){
            sum += num;
        }
        return sum / grades.size();
    }

    public String getName(){
        return this.evaluationName;
    }

    public String getStudentName(){
        return this.studentName;
    }

    public String getSubject(){
        return this.subject;
    }

    public String getEvaluationType(){
        return this.evaluationType;
    }

    public  String getEvaluationName(){
        return this.evaluationName;
    }

    void setPassed(boolean passed){
        this.passed = passed;
    }

    public String[] getData(){
        //Subject_Name,Evaluation_Name,Student_Name,Grade (rounded to 1 decimal place)
        return new String[]{this.subject, this.evaluationName, this.studentName, String.format("%.1f", getAverage())};
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Evaluation evaluation = (Evaluation) obj;
        return evaluationName.equals(evaluation.evaluationName);
    }

    @Override
    public int hashCode() {
        return evaluationName.hashCode();
    }
}
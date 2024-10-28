package TpUniversity.model.Evaluations;

import TpUniversity.model.Entity;
import TpUniversity.model.Exercise;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Evaluation extends Entity {

    private final ArrayList<Exercise> exercises;
    private final String evaluationName;
    private final String subject;
    private final String studentName;
    String evaluationType;
    private boolean passed;
    private boolean evaluated = false;
    private String criteria;
    private double criteriaValue;

    public Evaluation(String evaluationName, String subject, String studentName) {
        this.exercises = new ArrayList<>();
        this.evaluationName = evaluationName;
        this.subject = subject;
        this.studentName = studentName;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
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

    public boolean isEvaluated() {
        return this.evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public void setPassed(boolean passed){
        this.passed = passed;
    }

    public void setCriteriaValue(double criteriaValue) {
        this.criteriaValue = criteriaValue;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String[] getData(){
        //Subject_Name,Evaluation_Name,Student_Name,Grade (rounded to 1 decimal place)
        return new String[]{this.subject, this.evaluationName, this.studentName, String.format("%.1f", getAverage())};
    }
    public String[] getAltData() {
        //Subject_Name,Evaluation_Name,Student_Name,Evaluation_Type,Grade (rounded to 1 decimal place),Criteria,Criteria_Value,Passed,Min,Max
        return new String[]{this.subject, this.evaluationName, this.studentName, this.evaluationType,
                String.format("%.1f", getAverage()), this.criteria, String.valueOf(this.criteriaValue), String.valueOf(this.passed),
                String.format("%.1f", getMin()), String.format("%.1f", getMax())};
    }

    public double getAverage() {
        double sum = 0;
        for (Exercise exercise : exercises) {
            sum += exercise.getGrade();
        }
        return sum / exercises.size();
    }

    public double getMax() {
        double max = 0;
        for (Exercise exercise : exercises){
            double grade = exercise.getGrade();
            if (grade > max){
                max = grade;
            }
        }
        return max;
    }

    public double getMin() {
        double min = 10;
        for (Exercise exercise : exercises){
            double grade = exercise.getGrade();
            if (grade < min){
                min = grade;
            }
        }
        return min;
    }

    public double getLastGrade() {
        return exercises.getLast().getGrade();
    }

    protected double sumGrades() {
        double sum = 0;
        for (Exercise exercise : exercises) {
            sum += exercise.getGrade();
        }
        return sum;
    }

    public abstract double getRelevantGrade();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Evaluation evaluation = (Evaluation) obj;
        return evaluationName.equals(evaluation.evaluationName)
                && subject.equals(evaluation.subject)
                && studentName.equals(evaluation.studentName)
                && evaluationType.equals(evaluation.evaluationType)
                && this.getId() == evaluation.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(evaluationName, subject, studentName, evaluationType, getId());
    }


}
package TpUniversity.model.Evaluations;

public class FinalPracticalWork extends Evaluation {

    public FinalPracticalWork(String evaluationName, String subject, String studentName) {
        super(evaluationName, subject, studentName);
        this.setEvaluationType("FINAL_PRACTICAL_WORK");
    }

    @Override
    public double getRelevantGrade() {
        return this.sumGrades();
    }
}

package TpUniversity.model.Evaluations;

public class OralExam extends Evaluation {
    public OralExam(String evaluationName, String subject, String studentName) {
        super(evaluationName, subject, studentName);
        this.setEvaluationType("ORAL_EXAM");
    }

    @Override
    public double getRelevantGrade() {
        return this.getAverage();
    }
}
//
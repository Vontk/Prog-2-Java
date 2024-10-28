package TpUniversity.model.Evaluations;

public class WrittenExam extends Evaluation {
    public WrittenExam(String evaluationName, String subject, String studentName) {
        super(evaluationName, subject, studentName);
        this.setEvaluationType("WRITTEN_EXAM");
    }

    @Override
    public double getRelevantGrade() {
        return this.getAverage();
    }
}

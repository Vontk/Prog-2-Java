package TpUniversity.model.Evaluations;

public class PracticalWork extends Evaluation {
    public PracticalWork(String evaluationName, String subject, String studentName) {
        super(evaluationName, subject, studentName);
        this.setEvaluationType("PRACTICAL_WORK");
    }

    @Override
    public double getRelevantGrade() {
        return this.getLastGrade();
    }
}
//PRACTICAL_WORK
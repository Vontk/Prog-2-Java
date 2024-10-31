package TpUniversity.service.CriteriaAnalyzer;

import TpUniversity.model.Evaluations.Evaluation;

public class AverageAboveValue implements CriteriaApplier {

    public void apply(Evaluation evaluation, double value, String criteria) {
        evaluation.setEvaluated(true);
        evaluation.setCriteria(criteria);
        evaluation.setCriteriaValue(value);
        if (evaluation.getAverage() > value) {
            evaluation.setPassed(true);
        }
    }
}
package TpUniversity.service.EvaluationCriteriaManager;

import TpUniversity.model.Evaluations.Evaluation;

public class AverageAboveValue implements EvaluationCriteria {

    public void apply(Evaluation evaluation, double value, String criteria) {
        evaluation.setEvaluated(true);
        evaluation.setCriteria(criteria);
        evaluation.setCriteriaValue(value);
        if (evaluation.getAverage() > value) {
            evaluation.setPassed(true);
        }
    }
}
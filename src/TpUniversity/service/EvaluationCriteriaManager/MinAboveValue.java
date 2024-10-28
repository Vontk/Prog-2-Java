package TpUniversity.service.EvaluationCriteriaManager;

import TpUniversity.model.Evaluations.Evaluation;

public class MinAboveValue implements EvaluationCriteria {

    public void apply(Evaluation evaluation, double value, String criteria) {
        evaluation.setEvaluated(true);
        evaluation.setCriteria(criteria);
        evaluation.setCriteriaValue(value);
        if (evaluation.getMin() > value) {
            evaluation.setPassed(true);
        }
    }
}
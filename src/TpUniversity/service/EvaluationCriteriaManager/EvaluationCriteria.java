// File: src/TpUniversity/service/EvaluationCriteria.java
package TpUniversity.service.EvaluationCriteriaManager;

import TpUniversity.model.Evaluations.Evaluation;

public interface EvaluationCriteria {
    public void apply(Evaluation evaluation, double value, String criteria);
}
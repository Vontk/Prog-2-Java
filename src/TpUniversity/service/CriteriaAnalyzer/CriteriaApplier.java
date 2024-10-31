// File: src/TpUniversity/service/EvaluationCriteria.java
package TpUniversity.service.CriteriaAnalyzer;

import TpUniversity.model.Evaluations.Evaluation;

public interface CriteriaApplier {
    public void apply(Evaluation evaluation, double value, String criteria);
}
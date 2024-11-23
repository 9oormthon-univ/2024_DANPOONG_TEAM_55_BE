package goormthon.somtoring.domain.evaluate.domain;

public interface EvaluateRepository {
    void save(Evaluate evaluate);

    Evaluate findByMentee_Id(Long userId);
}

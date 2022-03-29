package pl.pabjan.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pabjan.fraud.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}

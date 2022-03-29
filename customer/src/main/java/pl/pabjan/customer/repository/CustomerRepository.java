package pl.pabjan.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pabjan.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

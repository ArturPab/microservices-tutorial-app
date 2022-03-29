package pl.pabjan.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pabjan.customer.model.Customer;
import pl.pabjan.customer.model.dto.CustomerRegistrationRequest;
import pl.pabjan.customer.model.dto.FraudCheckResponse;
import pl.pabjan.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());

        if(fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}

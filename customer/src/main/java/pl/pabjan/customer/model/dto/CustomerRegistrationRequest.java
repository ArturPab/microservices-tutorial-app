package pl.pabjan.customer.model.dto;

import lombok.Getter;

@Getter
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}

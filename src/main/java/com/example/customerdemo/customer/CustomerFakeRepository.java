package com.example.customerdemo.customer;

import java.util.Arrays;
import java.util.List;
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123","jb@gmail.com"),
                new Customer(2L, "James Harden", "123password","jh@gmail.com")
        );
    }
}

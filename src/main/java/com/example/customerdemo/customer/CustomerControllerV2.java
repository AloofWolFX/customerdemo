package com.example.customerdemo.customer;

import com.example.customerdemo.exception.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(path="api/v2/customers")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {
    private final CustomerService customerService;

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id){
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID "+ id);
    }


}

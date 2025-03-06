package com.example.lab.controller;

import com.example.lab.dto.*;
import com.example.lab.entity.Customercl;
import com.example.lab.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @PostMapping("/addClassification")
    public Customercl addClassification(@RequestBody CustomerClassificationDTO customerClassificationDTO)
    {
        return bankingService.addClassification(customerClassificationDTO);
    }
    // Create a new customer
    @PostMapping("/customers")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return bankingService.createCustomer(customerDTO);
    }

    // Save customer details
    @PostMapping("/customers/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return bankingService.saveCustomerDetails(customerDTO);
    }

    // Get a customer by ID
    @GetMapping("/customers/{id}")
    public Optional<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return bankingService.getCustomerById(id);
    }

    // Get all customers
    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers() {
        return bankingService.getAllCustomers();
    }

    // Delete a customer by ID
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        bankingService.deleteCustomer(id);
    }

    // Add an address for a customer
    @PostMapping("/customer-address")
    public CustomerAddressDTO addAddress(@RequestBody CustomerAddressDTO addressDTO) {
        return bankingService.addCustomerAddress(addressDTO);
    }

    // Save customer address
    @PostMapping("/customer-address/save")
    public CustomerAddressDTO saveCustomerAddress(@RequestBody CustomerAddressDTO customerAddressDTO) {
        return bankingService.saveCustomerAddress(customerAddressDTO);
    }

    // Get all addresses for a customer
    @GetMapping("/customer-address/{customerId}")
    public List<CustomerAddressDTO> getCustomerAddresses(@PathVariable Long customerId) {
        return bankingService.getCustomerAddresses(customerId);
    }

    // Register a new customer sign-in
    @PostMapping("/register")
    public CustomerSignInDTO registerCustomer(@RequestBody CustomerSignInDTO signInDTO) {
        return bankingService.registerCustomerSignIn(signInDTO);
    }

    // Authenticate customer sign-in
    @PostMapping("/authenticate")
    public CustomerSignInDTO authenticateCustomer(@RequestParam String userName, @RequestParam String password) {
        return bankingService.authenticateCustomer(userName, password);
    }
}

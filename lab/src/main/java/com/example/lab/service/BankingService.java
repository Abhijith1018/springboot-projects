package com.example.lab.service;

import com.example.lab.dto.CustomerClassificationDTO;
import com.example.lab.dto.CustomerDTO;
import com.example.lab.dto.CustomerAddressDTO;
import com.example.lab.dto.CustomerSignInDTO;
import com.example.lab.entity.Customercl;

import java.util.List;
import java.util.Optional;

public interface BankingService {

    // Customer operations
    CustomerDTO createCustomer(CustomerDTO customerDTO);  // ✅ Unified with `saveCustomerDetails`

    CustomerDTO saveCustomerDetails(CustomerDTO customerDTO);

    Optional<CustomerDTO> getCustomerById(Long id);

    CustomerAddressDTO saveCustomerAddress(CustomerAddressDTO customerAddressDTO);

    List<CustomerDTO> getAllCustomers();
    void deleteCustomer(Long id);

    // Address operations
    CustomerAddressDTO addCustomerAddress(CustomerAddressDTO addressDTO);  // ✅ Removed redundancy
    List<CustomerAddressDTO> getCustomerAddresses(Long customerId);

    // Sign-in operations
    CustomerSignInDTO registerCustomerSignIn(CustomerSignInDTO signInDTO);  // ✅ Removed duplicate register method
    CustomerSignInDTO authenticateCustomer(String userName, String password);

    Customercl addClassification(CustomerClassificationDTO customerClassificationDTO);
}

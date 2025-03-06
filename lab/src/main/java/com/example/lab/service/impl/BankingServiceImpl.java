package com.example.lab.service.impl;

import com.example.lab.DAO.*;
import com.example.lab.dto.*;
import com.example.lab.entity.*;
import com.example.lab.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.sql.Date;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerSignInRepository customerSignInRepository;

    @Autowired
    private CustomerClassificationRepository classificationRepo; // ✅ Injected

    // Create new customer
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerDetails customer = new CustomerDetails(customerDTO, classificationRepo); // ✅ Fixed constructor call
        customer = customerDetailsRepository.save(customer);

        // Update the record
        // Set effective date if null
        if (customer.getEfctv_date() == null) {
            customer.setEfctv_date(new Date(System.currentTimeMillis()));
        }

        // Set timestamps
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        customer.setHost_ts(currentTimestamp);
        customer.setLocal_ts(currentTimestamp);
        customer.setCrud_value('C');
        customer = customerDetailsRepository.save(customer);
        return new CustomerDTO(customer);
    }

    @Override
    public CustomerAddressDTO addCustomerAddress(CustomerAddressDTO addressDTO) {
        CustomerAddress address = new CustomerAddress(addressDTO);

        // Set effective date if null
        if (address.getEfctvDate() == null) {
            address.setEfctvDate(new Date(System.currentTimeMillis()));
        }

        // Fetch customer
        CustomerDetails customer = customerDetailsRepository.findById(addressDTO.getCustomerId()).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found!");
        }

        address.setCustDetails(customer);

        // Set timestamps
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        address.setHost_ts(currentTimestamp);
        address.setLocal_ts(currentTimestamp);
        address.setAcpt_ts(currentTimestamp);

        // Save after setting timestamps
        address = customerAddressRepository.save(address);
        return new CustomerAddressDTO(address);
    }

    // Register customer login credentials
    @Override
    public CustomerSignInDTO registerCustomerSignIn(CustomerSignInDTO signInDTO) {
        // Ensure customer exists
        CustomerDetails customer = customerDetailsRepository.findById(signInDTO.getCustomerId()).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found!");
        }

        Customersignin signin = new Customersignin(signInDTO);
        signin.setCust_DETAILS(customer);

        // Set timestamps
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        signin.setHost_ts(currentTimestamp);
        signin.setLocal_ts(currentTimestamp);

        signin = customerSignInRepository.save(signin);
        return new CustomerSignInDTO(signin);
    }

    @Override
    public CustomerDTO saveCustomerDetails(CustomerDTO customerDTO) {
        return createCustomer(customerDTO); // ✅ Avoid duplicate logic
    }

    // Fetch customer by ID
    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerDetailsRepository.findById(id).map(CustomerDTO::new);
    }

    // Delete customer by ID
    @Override
    public void deleteCustomer(Long id) {
        if (!customerDetailsRepository.existsById(id)) {
            throw new RuntimeException("Customer not found!");
        }
        customerDetailsRepository.deleteById(id);
    }

    @Override
    public CustomerAddressDTO saveCustomerAddress(CustomerAddressDTO customerAddressDTO) {
        return addCustomerAddress(customerAddressDTO);
    }

    // Get all customers
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerDetailsRepository.findAll().stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }

    // Get all addresses for a customer
    @Override
    public List<CustomerAddressDTO> getCustomerAddresses(Long customerId) {
        List<CustomerAddress> addresses = customerAddressRepository.findByCustDetails_Id(customerId);
        return addresses.stream().map(CustomerAddressDTO::new).collect(Collectors.toList());
    }



    // Authenticate customer sign-in
    @Override
    public CustomerSignInDTO authenticateCustomer(String userName, String password) {
        Optional<Customersignin> signIn = customerSignInRepository.findByUserNameAndPassword(userName, password);
        return signIn.map(CustomerSignInDTO::new).orElse(null);
    }

    @Override
    public Customercl addClassification(CustomerClassificationDTO customerClassificationDTO)
    {
        Customercl customercl = new Customercl();
        customercl.setType(customerClassificationDTO.getType());
        customercl.setTypeValue(customerClassificationDTO.getValue());
        customercl.setCrud_value('C');
        customercl.setEfctv_date(new Date(System.currentTimeMillis()));
        customercl.setHost_ts(new Timestamp(System.currentTimeMillis()));
        customercl.setAcpt_ts(new Timestamp(System.currentTimeMillis()));
        customercl.setAcpt_ts_utc_ofst(new Timestamp(System.currentTimeMillis()));
        customercl.setLocal_ts(new Timestamp(System.currentTimeMillis()));
        customercl.setWs_id("WS001");
        customercl.setPrgm_id("Pr101");
        customercl.setUser_id("Abhijith");
        customercl.setUUID("huag878q9qvnthhgbjm0952ivjgj");
        return classificationRepo.save(customercl);
    }
}

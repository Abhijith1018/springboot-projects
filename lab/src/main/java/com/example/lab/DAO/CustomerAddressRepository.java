package com.example.lab.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab.entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
    List<CustomerAddress> findByCustDetails_Id(Long customerId);
}

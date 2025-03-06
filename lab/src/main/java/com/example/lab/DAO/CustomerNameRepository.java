package com.example.lab.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab.entity.CustomerName;

public interface CustomerNameRepository extends JpaRepository<CustomerName, Long>{

}


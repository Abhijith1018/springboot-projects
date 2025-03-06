package com.example.lab.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab.entity.CustomerId;

public interface CustomerIdRepository extends JpaRepository<CustomerId, Long>{

}


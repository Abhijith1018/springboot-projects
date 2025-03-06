package com.example.lab.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lab.entity.Customercl;

public interface CustomerClassificationRepository extends JpaRepository<Customercl, Long> {
    //@Query("SELECT c FROM Customercl WHERE c.id = :id")
    //public Customercl findClassificationRecord(@Param("id") Long id);
}


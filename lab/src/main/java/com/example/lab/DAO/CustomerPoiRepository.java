package com.example.lab.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab.entity.Custpoi;

public interface CustomerPoiRepository extends JpaRepository<Custpoi, Long> {

}

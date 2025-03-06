package com.example.lab.DAO;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab.entity.Customersignin;

public interface CustomerSignInRepository extends JpaRepository<Customersignin, Long> {
    Optional<Customersignin> findByUserNameAndPassword(String userName, String password);
}

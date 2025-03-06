package com.example.lab.dto;


import com.example.lab.entity.Customersignin;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerSignInDTO {
    private Long id;
    private String username;
    private String role;
    private String password;
    private Long customerId;

    public CustomerSignInDTO(Customersignin user) {
        this.id = user.getId();
        this.username = user.getUserName();
        this.role = user.getRole();
        this.password=user.getPassword();
    }
}



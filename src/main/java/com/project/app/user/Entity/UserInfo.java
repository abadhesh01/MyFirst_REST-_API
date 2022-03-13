package com.project.app.user.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    
    private String fname;
    private String lname;
    private String role;
    private String email;
    private String state;
    private String country;
    private List<Product> products;
    
}

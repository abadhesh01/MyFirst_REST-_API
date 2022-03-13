package com.project.app.user.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "personalinfo")
public class PersonalInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long infoId;

    private String email;

    private String state;

    private String country;
}

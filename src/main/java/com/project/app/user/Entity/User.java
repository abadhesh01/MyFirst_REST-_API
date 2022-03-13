package com.project.app.user.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private long uid;

    @Column(name = "f_name", nullable = false)
    private String fname;

    @Column(name = "l_name", nullable = false)
    private String lname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_role")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personalinfo")
    private PersonalInfo personalInfo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product")
    private List<Product> products;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fk_comment")
    //private List<Comment> comments;
}

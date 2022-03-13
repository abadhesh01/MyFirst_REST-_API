package com.project.app.user.Repository;

import java.util.List;

import com.project.app.user.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("select u from User u where u.fname like :pattern%")
    public List<User> getAllUsersWithFirstNamePattern(@Param("pattern") String pattern);

    @Query("select u from User u where u.fname like ?1% and u.lname like ?2%")
    public List<User> getAllUsersWithNamePattern(String f, String l);
    
}

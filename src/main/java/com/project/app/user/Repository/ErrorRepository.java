package com.project.app.user.Repository;

import com.project.app.user.Exception.ErrorDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<ErrorDetails, Long>{
    
}

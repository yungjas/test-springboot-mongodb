package com.testspring.demo.Repository;

import com.testspring.demo.model.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FormRepository extends MongoRepository<Form, String>{
    
}

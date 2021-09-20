package com.ganesh.repository;


import com.ganesh.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @created: 20/09/2021 - 11:52 AM
 * @author: Ganesh
 */

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    //Customs Query Methods
    Optional<Student> findStudentByEmail(String email);

}

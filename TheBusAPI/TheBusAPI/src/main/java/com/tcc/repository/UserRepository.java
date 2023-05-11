package com.tcc.repository;

import com.tcc.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<List<User>> findByEmailAndPassword(String email, String password);

}

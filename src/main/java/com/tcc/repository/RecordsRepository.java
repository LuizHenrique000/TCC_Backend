package com.tcc.repository;

import com.tcc.model.Records;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordsRepository extends MongoRepository<Records, String> {
}

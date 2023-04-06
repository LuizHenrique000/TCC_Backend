package com.tcc.repository;

import com.tcc.model.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioRepository extends MongoRepository<Horario, String> {
}

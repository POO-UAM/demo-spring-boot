package com.fbc.democlase.Repositorios;

import com.fbc.democlase.Modelos.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioProfesor extends MongoRepository<Profesor,String> {
}

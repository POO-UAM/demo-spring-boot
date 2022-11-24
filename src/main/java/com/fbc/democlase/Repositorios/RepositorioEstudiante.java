package com.fbc.democlase.Repositorios;

import com.fbc.democlase.Modelos.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioEstudiante extends MongoRepository<Estudiante,String> {
}

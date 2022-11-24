package com.fbc.democlase.Repositorios;

import com.fbc.democlase.Modelos.Inscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioInscripcion extends MongoRepository<Inscripcion,String> {
}

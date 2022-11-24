package com.fbc.democlase.Repositorios;

import com.fbc.democlase.Modelos.Departamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioDepartamento extends MongoRepository<Departamento,String> {


}

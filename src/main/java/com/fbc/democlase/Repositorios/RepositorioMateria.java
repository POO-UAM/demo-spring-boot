package com.fbc.democlase.Repositorios;

import com.fbc.democlase.Modelos.Departamento;
import com.fbc.democlase.Modelos.Materia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioMateria extends MongoRepository<Materia,String> {
    @Query("{'miDepartamento.$id': ObjectId(?0)}")
    List<Materia> getMateriasEnDepartamento(String idDepartamento);
}

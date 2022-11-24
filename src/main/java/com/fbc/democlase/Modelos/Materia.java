package com.fbc.democlase.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Materia {
    @Id
    private String _id;
    private String inicialesMateria;
    private String descripcion;
    @DBRef
    private Departamento miDepartamento;

    public Materia(String inicialesMateria, String descripcion) {
        this.setInicialesMateria(inicialesMateria);
        this.setDescripcion(descripcion);
    }

    public String get_id() {
        return _id;
    }


    public String getInicialesMateria() {
        return inicialesMateria;
    }

    public void setInicialesMateria(String inicialesMateria) {
        this.inicialesMateria = inicialesMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

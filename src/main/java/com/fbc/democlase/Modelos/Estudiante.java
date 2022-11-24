package com.fbc.democlase.Modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Estudiante extends Persona{
    private String apellido;
    private String inicialesDepartamento;
    private String municipioResidencia;

    public Estudiante(){

    }
    public Estudiante(String cedula, String nombre, String email, String apellido, String inicialesDepartamento, String municipioResidencia) {
        super(cedula, nombre, email);
        this.setApellido(apellido);
        this.setInicialesDepartamento(inicialesDepartamento);
        this.setMunicipioResidencia(municipioResidencia);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInicialesDepartamento() {
        return inicialesDepartamento;
    }

    public void setInicialesDepartamento(String inicialesDepartamento) {
        this.inicialesDepartamento = inicialesDepartamento;
    }

    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }
}

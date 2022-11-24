package com.fbc.democlase.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Profesor extends Persona{
    private String profesion;
    private int anosExperiencia;
    @DBRef
    private
    Departamento miDepartamento;

    public Profesor(){
    }
    public Profesor(String cedula, String nombre, String email, String profesion, int anosExperiencia) {
        super(cedula, nombre, email);
        this.setProfesion(profesion);
        this.setAnosExperiencia(anosExperiencia);
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
}

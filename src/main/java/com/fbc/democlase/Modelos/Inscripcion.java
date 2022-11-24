package com.fbc.democlase.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Inscripcion {
    @Id
    private String _id;
    private int semestre;
    private double notaFinal;
    @DBRef
    private Estudiante miEstudiante;
    @DBRef
    private Materia miMateria;

    public Inscripcion() {

    }

    public Inscripcion(int semestre, double notaFinal) {
        this.setSemestre(semestre);
        this.setNotaFinal(notaFinal);
    }

    public String get_id() {
        return _id;
    }

    public int getSemestre() {
        return semestre;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    public Estudiante getMiEstudiante() {
        return miEstudiante;
    }

    public Materia getMiMateria() {
        return miMateria;
    }

    public void setMiEstudiante(Estudiante miEstudiante) {
        this.miEstudiante = miEstudiante;
    }

    public void setMiMateria(Materia miMateria) {
        this.miMateria = miMateria;
    }
}

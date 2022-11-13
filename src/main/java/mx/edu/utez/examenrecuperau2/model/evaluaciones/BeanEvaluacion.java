package mx.edu.utez.examenrecuperau2.model.evaluaciones;

import mx.edu.utez.examenrecuperau2.model.estudiantes.BeanEstudiante;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanEvaluacion {
    long id;
    String materia;
    int calificacion;
    BeanEstudiante alumno;

    public BeanEvaluacion() {
    }

    public BeanEvaluacion(long id, String materia, int calificacion, BeanEstudiante alumno) {
        this.id = id;
        this.materia = materia;
        this.calificacion = calificacion;
        this.alumno = alumno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public BeanEstudiante getAlumno() {
        return alumno;
    }

    public void setAlumno(BeanEstudiante alumno) {
        this.alumno = alumno;
    }
}

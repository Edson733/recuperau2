package mx.edu.utez.examenrecuperau2.model.estudiantes;

import mx.edu.utez.examenrecuperau2.model.docentes.BeanDocente;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanEstudiante {
    long id;
    String nombre;
    String apellidoP;
    String apellidoM;
    String curp;
    String matricula;
    BeanDocente maestro;

    public BeanEstudiante() {
    }

    public BeanEstudiante(long id, String nombre, String apellidoP, String apellidoM, String curp, String matricula, BeanDocente maestro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.matricula = matricula;
        this.maestro = maestro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BeanDocente getMaestro() {
        return maestro;
    }

    public void setMaestro(BeanDocente maestro) {
        this.maestro = maestro;
    }
}

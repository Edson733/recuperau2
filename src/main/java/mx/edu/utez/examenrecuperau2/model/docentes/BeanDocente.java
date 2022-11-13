package mx.edu.utez.examenrecuperau2.model.docentes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanDocente {
    long id;
    String nombre;
    String apellidoP;
    String apellidoM;
    String fechaNac;
    String curp;
    long num_empleado;

    public BeanDocente() {
    }

    public BeanDocente(long id, String nombre, String apellidoP, String apellidoM, String fechaNac, String curp, long num_empleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.curp = curp;
        this.num_empleado = num_empleado;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public long getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(long num_empleado) {
        this.num_empleado = num_empleado;
    }
}

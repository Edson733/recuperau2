package mx.edu.utez.examenrecuperau2.model.evaluaciones;

import mx.edu.utez.examenrecuperau2.model.docentes.BeanDocente;
import mx.edu.utez.examenrecuperau2.model.estudiantes.BeanEstudiante;
import mx.edu.utez.examenrecuperau2.model.estudiantes.DaoEstudiante;
import mx.edu.utez.examenrecuperau2.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEvaluaciones {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    public List<BeanEvaluacion> findAll(){
        List<BeanEvaluacion> evaluacion = new ArrayList<>();
        BeanEvaluacion calificacion = null;
        BeanEstudiante alumno = null;
        try{
            connection = client.getConnection();
            String query = "SELECT evaluaciones.id_Evaluacion, estudiantes.nombre, evaluaciones.materia, \n" +
                    "evaluaciones.calificacion FROM evaluaciones JOIN estudiantes ON evaluaciones.alumno = estudiantes.id_Estudiante;";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                calificacion = new BeanEvaluacion();
                alumno = new BeanEstudiante();
                calificacion.setId(rs.getLong("id_Evaluacion"));
                calificacion.setMateria(rs.getString("materia"));
                calificacion.setCalificacion(rs.getInt("calificacion"));
                alumno.setNombre(rs.getString("nombre"));
                calificacion.setAlumno(alumno);
                evaluacion.add(calificacion);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEvaluaciones.class.getName()).log(Level.SEVERE, "Error -> findAll: " + e.getMessage());
        }finally {
            client.close(connection, pstm, rs);
        }
        return evaluacion;
    }

    public BeanEvaluacion findOne(long id){
        BeanEvaluacion evaluacion = null;
        BeanEstudiante estudiante = null;
        try{
            connection = client.getConnection();
            String query = "SELECT evaluaciones.id_Evaluacion, estudiantes.nombre, evaluaciones.materia, \n" +
                    "evaluaciones.calificacion FROM evaluaciones JOIN estudiantes ON evaluaciones.alumno = estudiantes.id_Estudiante WHERE \n" +
                    "estudiantes.id_Estudiante = ?;;";
            pstm = connection.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()){
                evaluacion = new BeanEvaluacion();
                estudiante = new BeanEstudiante();
                evaluacion.setId(rs.getLong("id_Docente"));
                evaluacion.setMateria(rs.getString("materia"));;
                evaluacion.setCalificacion(rs.getInt("calificacion"));
                estudiante.setNombre(rs.getString("nombre"));
                evaluacion.setAlumno(estudiante);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEvaluaciones.class.getName()).log(Level.SEVERE, "Error -> findOne: " + e.getMessage());
        }finally {
            client.close(connection, pstm, rs);
        }
        return evaluacion;
    }

    public List<BeanEvaluacion> promedio() {
        List<BeanEvaluacion> evaluacion = new ArrayList<>();
        BeanEvaluacion calificacion = null;
        try {
            connection = client.getConnection();
            String query = "SELECT AVG(calificacion) AS promedio FROM evaluaciones;";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                calificacion = new BeanEvaluacion();
                calificacion.setCalificacion(rs.getInt("promedio"));
                evaluacion.add(calificacion);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEvaluaciones.class.getName()).log(Level.SEVERE, "Error -> promedio" + e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return evaluacion;
    }
}

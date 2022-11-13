package mx.edu.utez.examenrecuperau2.model.estudiantes;

import mx.edu.utez.examenrecuperau2.model.docentes.BeanDocente;
import mx.edu.utez.examenrecuperau2.utils.MySQLConnection;
import mx.edu.utez.examenrecuperau2.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEstudiante {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    public List<BeanEstudiante> findAll(){
        List<BeanEstudiante> estudiante = new ArrayList<>();
        BeanEstudiante alumno = null;
        BeanDocente maestro = null;
        try{
            connection = client.getConnection();
            String query = "SELECT * FROM estudiantes;";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                alumno = new BeanEstudiante();
                maestro = new BeanDocente();
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoP(rs.getString("apellidoP"));
                alumno.setApellidoM(rs.getString("apellidoM"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setMatricula(rs.getString("matricula"));
                maestro.setNombre(rs.getString("nombre"));
                alumno.setMaestro(maestro);
                estudiante.add(alumno);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE, "Error -> findAll: " + e.getMessage());
        }finally {
            client.close(connection, pstm, rs);
        }
        return estudiante;
    }

    public BeanEstudiante findOne(long id){
        BeanEstudiante estudiante = null;
        BeanDocente maestro = null;
        try{
            connection = client.getConnection();
            String query = "SELECT * FROM estudiantes WHERE id_Estudiante = ?;";
            pstm = connection.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()){
                estudiante = new BeanEstudiante();
                maestro = new BeanDocente();
                estudiante.setId(rs.getLong("id_Estudiante"));
                estudiante.setNombre(rs.getString("nombre"));;
                estudiante.setApellidoP(rs.getString("apellidoP"));
                estudiante.setApellidoM(rs.getString("apellidoM"));
                estudiante.setCurp(rs.getString("curp"));
                estudiante.setMatricula(rs.getString("matricula"));
                maestro.setNombre(rs.getString("nombre"));
                estudiante.setMaestro(maestro);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE, "Error -> findOne: " + e.getMessage());
        }finally {
            client.close(connection, pstm, rs);
        }
        return estudiante;
    }

    public Response<BeanEstudiante> save(BeanEstudiante estudiante){
        try{
            connection = client.getConnection();
            String query = "INSERT INTO estudiantes(nombre, apellidoP, apellidoM, curp, matricula, maestro) VALUES(?, ?, ?, ?, ?, ?);";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, estudiante.getNombre());
            pstm.setString(2, estudiante.getApellidoP());
            pstm.setString(3, estudiante.getApellidoM());
            pstm.setString(4, estudiante.getCurp());
            pstm.setString(5, estudiante.getMatricula());
            pstm.setLong(6, estudiante.getMaestro().getId());
            if (pstm.executeUpdate() == 1){
                return new Response<>(200, "Registro Correctamente", estudiante, false);
            }else{
                return new Response<>(400, "Error al Registrar", estudiante, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE, "Error -> save: " + e.getMessage());
            return new Response<>(400, "Error al Registrar", null, true);
        }finally {
            client.close(connection, pstm, rs);
        }
    }

    public Response<BeanEstudiante> update(BeanEstudiante estudiante){
        try{
            connection = client.getConnection();
            String query = "UPDATE estudiantes SET nombre = ?, apellidoP = ?, apellidoM = ?, curp = ?, matricula = ?, maestro = ? WHERE id_Estudiante = ?;";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, estudiante.getNombre());
            pstm.setString(2, estudiante.getApellidoP());
            pstm.setString(3, estudiante.getApellidoM());
            pstm.setString(4, estudiante.getCurp());
            pstm.setString(5, estudiante.getMatricula());
            pstm.setLong(6, estudiante.getMaestro().getId());
            pstm.setLong(7, estudiante.getId());
            if (pstm.executeUpdate() == 1){
                return new Response<>(200, "Actualizacion Correctamente", estudiante, false);
            }else{
                return new Response<>(400, "Actualizacion Incorrectamente", estudiante, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE, "Error -> update: " + e.getMessage());
            return new Response<>(400, "Error al Actualizar", null, true);
        }finally {
            client.close(connection, pstm, rs);
        }
    }

    public String delete(long id){
        try{
            connection = client.getConnection();
            String query = "DELETE FROM estudiantes WHERE id_Estudiante = ?;";
            pstm = connection.prepareStatement(query);
            pstm.setLong(1, id);
            if (pstm.executeUpdate() == 1){
                return "Eliminacion Correctamente";
            }else{
                return "Eliminacion Incorrectamente";
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEstudiante.class.getName()).log(Level.SEVERE, "Error -> delete: " + e.getMessage());
            return "Error al Eliminar";
        }finally {
            client.close(connection, pstm, rs);
        }
    }
}

package mx.edu.utez.examenrecuperau2.model.docentes;

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

public class DaoDocente {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    public List<BeanDocente> findAll(){
        List<BeanDocente> docente = new ArrayList<>();
        BeanDocente maestro = null;
        try{
            connection = client.getConnection();
            String query = "SELECT * FROM docentes;";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                maestro = new BeanDocente();
                maestro.setId(rs.getLong("id_Docente"));
                maestro.setNombre(rs.getString("nombre"));
                maestro.setApellidoP(rs.getString("apellidoP"));
                maestro.setApellidoM(rs.getString("apellidoM"));
                maestro.setFechaNac(rs.getString("fechaNac"));
                maestro.setCurp(rs.getString("curp"));
                maestro.setNum_empleado(rs.getLong("num_empleado"));
                docente.add(maestro);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> findAll: " + e.getMessage());
        }finally {
            client.close(connection, pstm, rs);
        }
        return docente;
    }

    public BeanDocente findOne(long id){
        BeanDocente docente = null;
        try{
            connection = client.getConnection();
            String query = "SELECT * FROM docentes WHERE id_Docente = ?;";
            pstm = connection.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()){
                docente = new BeanDocente();
                docente.setId(rs.getLong("id_Docente"));
                docente.setNombre(rs.getString("nombre"));;
                docente.setApellidoP(rs.getString("apellidoP"));
                docente.setApellidoM(rs.getString("apellidoM"));
                docente.setFechaNac(rs.getString("fechaNac"));
                docente.setCurp(rs.getString("curp"));
                docente.setNum_empleado(rs.getLong("num_empleado"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> findOne: " + e.getMessage());
        }finally {
            client.close(connection, pstm, rs);
        }
        return docente;
    }

    public Response<BeanDocente> save(BeanDocente docente){
        try{
            connection = client.getConnection();
            String query = "INSERT INTO docentes(nombre, apellidoP, apellidoM, fechaNac, curp, num_empleado) VALUES(?, ?, ?, ?, ?, ?);";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, docente.getNombre());
            pstm.setString(2, docente.getApellidoP());
            pstm.setString(3, docente.getApellidoM());
            pstm.setString(4, docente.getFechaNac());
            pstm.setString(5, docente.getCurp());
            pstm.setLong(6, docente.getNum_empleado());
            if (pstm.executeUpdate() == 1){
                return new Response<>(200, "Registro Correctamente", docente, false);
            }else{
                return new Response<>(400, "Error al Registrar", docente, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> save: " + e.getMessage());
            return new Response<>(400, "Error al Registrar", null, true);
        }finally {
            client.close(connection, pstm, rs);
        }
    }

    public Response<BeanDocente> update(BeanDocente docente){
        try{
            connection = client.getConnection();
            String query = "UPDATE docentes SET nombre = ?, apellidoP = ?, apellidoM = ?, fechaNac = ?, curp = ?, num_Empleado = ? WHERE id_Docente = ?;";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, docente.getNombre());
            pstm.setString(2, docente.getApellidoP());
            pstm.setString(3, docente.getApellidoM());
            pstm.setString(4, docente.getFechaNac());
            pstm.setString(5, docente.getCurp());
            pstm.setLong(6, docente.getNum_empleado());
            pstm.setLong(7, docente.getId());
            if (pstm.executeUpdate() == 1){
                return new Response<>(200, "Actualizacion Correctamente", docente, false);
            }else{
                return new Response<>(400, "Actualizacion Incorrectamente", docente, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> update: " + e.getMessage());
            return new Response<>(400, "Error al Actualizar", null, true);
        }finally {
            client.close(connection, pstm, rs);
        }
    }

    public String delete(long id){
        try{
            connection = client.getConnection();
            String query = "DELETE FROM docentes WHERE id_Docente = ?;";
            pstm = connection.prepareStatement(query);
            pstm.setLong(1, id);
            if (pstm.executeUpdate() == 1){
                return "Eliminacion Correctamente";
            }else{
                return "Eliminacion Incorrectamente";
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> delete: " + e.getMessage());
            return "Error al Eliminar";
        }finally {
            client.close(connection, pstm, rs);
        }
    }
}

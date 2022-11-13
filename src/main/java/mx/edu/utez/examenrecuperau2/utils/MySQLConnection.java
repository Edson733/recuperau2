package mx.edu.utez.examenrecuperau2.utils;

import java.sql.*;

public class MySQLConnection {
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/recuperau2", "edson", "edson733");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            Connection conexion = MySQLConnection.getConnection();
            if(conexion != null) {
                System.out.println("Conectado");
                conexion.close();
            }else {
                System.err.println("No Conectado");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(Connection connection, PreparedStatement pstm, ResultSet rs){
        try{
            if (connection != null)
                connection.close();
            if (pstm != null)
                pstm.close();
            if (rs != null)
                rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

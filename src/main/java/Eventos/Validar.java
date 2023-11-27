package Eventos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validar {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = cn.getConnection();

    public boolean siexiste(String table, String item, String valor, String id) {
        String sql;
        try {
            if (id.equalsIgnoreCase("")) {
                sql = "SELECT id FROM " + table + " WHERE " + item + " = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, valor);
            } else {
                sql = "SELECT id FROM " + table + " WHERE " + item + " = ? AND id != ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, valor);
                ps.setString(2, id);
            }
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public String verificarCampo(String table, String item, int id) {
        String respuesta = null;
        String sql;
        try {
            sql = "SELECT " + item + " FROM " + table + " WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                respuesta = rs.getString(item);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            respuesta = null;
        }
        return respuesta;
    }

}

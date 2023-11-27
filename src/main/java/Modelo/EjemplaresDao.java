package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EjemplaresDao {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = cn.getConnection();

    public int registrar(Ejemplares ej) {
        int result = 0;
        String sql = "INSERT INTO ejemplares (nombre,geolocalizacion,estado,id_producto) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ej.getNombre());
            ps.setString(2, ej.getGeolocalizacion());
            ps.setString(3, ej.getEstado());
            ps.setInt(4, ej.getId_producto());
            int res = ps.executeUpdate();
            if (res == 0) {
                result = 0;
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }

    public boolean modificar(Ejemplares pro) {
        String sql = "UPDATE ejemplares SET nombre=?,geolocalizacion=?,estado=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getGeolocalizacion());
            ps.setString(3, pro.getEstado());
            ps.setInt(4, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List listar(String estado, String valorBusqueda) {
        List<Ejemplares> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String status = estado.equals("") ? "" : " WHERE estado = ?";
                String sql = "SELECT * FROM ejemplares" + status;
                ps = con.prepareStatement(sql);
            } else {
                String status = estado.equals("") ? "" : " AND estado = ?";
                String busqueda = "SELECT * FROM ejemplares WHERE nombre LIKE '%" + valorBusqueda + "%'" + status;
                ps = con.prepareStatement(busqueda);
            }
            if (!estado.equals("")) {
                ps.setString(1, estado);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplares ej = new Ejemplares();
                ej.setId(rs.getInt("id"));
                ej.setNombre(rs.getString("nombre"));
                ej.setGeolocalizacion(rs.getString("geolocalizacion"));
                ej.setEstado(rs.getString("estado"));
                lista.add(ej);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean registrarBitacora(String accion, String campo, String anterior, String nuevo, int id_ejemplar, int id_usuario) {
        String sql = "INSERT INTO bit_ejemplares(accion,campo,valor_ant,valor_nuevo,id_ejemplar,id_usuario) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, accion);
            ps.setString(2, campo);
            ps.setString(3, anterior);
            ps.setString(4, nuevo);
            ps.setInt(5, id_ejemplar);
            ps.setInt(6, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Ejemplares buscarEjemplar(String id) {
        Ejemplares ej = new Ejemplares();
        String sql = "SELECT * FROM ejemplares WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ej.setId(rs.getInt("id"));
                ej.setNombre(rs.getString("nombre"));
                ej.setGeolocalizacion(rs.getString("geolocalizacion"));
                ej.setStock(rs.getInt("stock"));
                ej.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ej;
    }

    public boolean actualizarEstado(String item, String valor, int id) {
        String sql = "UPDATE ejemplares SET " + item + "=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public int totalProductos(String id_producto) {
        int result = 0;
        String sql = "SELECT COUNT(id) AS total FROM ejemplares WHERE id_producto = ? AND estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id_producto);
            ps.setString(2, "Disponible");
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return result;
    }

    ///LISTAR BITACORAS    
    public List listarBitacora(String valorBusqueda) {
        List<BitEjemplares> lista = new ArrayList();
        String sql = "SELECT b.*, e.nombre, u.nombre AS usuario FROM bit_ejemplares b INNER JOIN ejemplares e ON b.id_ejemplar = e.id INNER JOIN usuarios u ON b.id_usuario = u.id";
        String busqueda = "SELECT b.*, e.nombre, u.nombre AS usuario FROM bit_ejemplares b INNER JOIN ejemplares e ON b.id_ejemplar = e.id INNER JOIN usuarios u ON b.id_usuario = u.id WHERE b.accion LIKE '%" + valorBusqueda + "%' OR b.campo LIKE '%" + valorBusqueda + "%' OR e.nombre LIKE '%" + valorBusqueda + "%'";
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
            } else {
                ps = con.prepareStatement(busqueda);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                BitEjemplares ej = new BitEjemplares();
                ej.setId(rs.getInt("id"));
                ej.setFecha_hora(rs.getString("fecha_hora"));
                ej.setAccion(rs.getString("accion"));
                ej.setCampo(rs.getString("campo"));
                ej.setValor_ant(rs.getString("valor_ant"));
                ej.setValor_nuevo(rs.getString("valor_nuevo"));
                ej.setEjemplar(rs.getString("nombre"));
                ej.setUsuario(rs.getString("usuario"));
                lista.add(ej);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public List listarEjemplar(int id_producto, String valorBusqueda) {
        List<Ejemplares> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String sql = "SELECT * FROM ejemplares WHERE id_producto = ?";
                ps = con.prepareStatement(sql);
            } else {
                String busqueda = "SELECT * FROM ejemplares WHERE nombre LIKE '%" + valorBusqueda + "%' AND id_producto = ?";
                ps = con.prepareStatement(busqueda);
            }
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplares ej = new Ejemplares();
                ej.setId(rs.getInt("id"));
                ej.setNombre(rs.getString("nombre"));
                ej.setGeolocalizacion(rs.getString("geolocalizacion"));
                ej.setEstado(rs.getString("estado"));
                lista.add(ej);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public List listarEjemplarEstado(int id_producto, String valorBusqueda) {
        List<Ejemplares> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String sql = "SELECT * FROM ejemplares WHERE id_producto = ?";
                ps = con.prepareStatement(sql);
            } else {
                String busqueda = "SELECT * FROM ejemplares WHERE estado LIKE '%" + valorBusqueda + "%' AND id_producto = ?";
                ps = con.prepareStatement(busqueda);
            }
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplares ej = new Ejemplares();
                ej.setId(rs.getInt("id"));
                ej.setNombre(rs.getString("nombre"));
                ej.setGeolocalizacion(rs.getString("geolocalizacion"));
                ej.setEstado(rs.getString("estado"));
                lista.add(ej);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
}

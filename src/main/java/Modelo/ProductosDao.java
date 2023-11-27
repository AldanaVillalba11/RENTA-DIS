package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductosDao {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = cn.getConnection();

    public int registrar(Productos pro) {
        int result = 0;
        String sql = "INSERT INTO productos (nombre,descripcion,precio,stock,estado) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
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

    public int registrarDetalle(int id_producto, int id_accesorio) {
        int result = 0;
        String sql = "INSERT INTO detalle_productos (id_accesorio,id_producto) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_accesorio);
            ps.setInt(2, id_producto);
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

    public boolean modificar(Productos pro) {
        String sql = "UPDATE productos SET nombre=?,descripcion=?,precio=?,stock=?,estado=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List listar(String estado, String valorBusqueda) {
        List<Productos> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String status = estado.equals("") ? "" : " WHERE estado = ?";
                String sql = "SELECT * FROM productos" + status;
                ps = con.prepareStatement(sql);
            } else {
                String status = estado.equals("") ? "" : " AND estado = ?";
                String busqueda = "SELECT * FROM productos WHERE nombre LIKE '%" + valorBusqueda + "%'" + status;
                ps = con.prepareStatement(busqueda);
            }
            if (!estado.equals("")) {
                ps.setString(1, estado);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
                pro.setEstado(rs.getString("estado"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean registrarBitacora(String accion, String campo, String anterior, String nuevo, int id_producto, int id_usuario) {
        String sql = "INSERT INTO bit_productos(accion,campo,valor_ant,valor_nuevo,id_producto,id_usuario) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, accion);
            ps.setString(2, campo);
            ps.setString(3, anterior);
            ps.setString(4, nuevo);
            ps.setInt(5, id_producto);
            ps.setInt(6, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Productos buscarProducto(String id) {
        Productos pro = new Productos();
        String sql = "SELECT * FROM productos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
                pro.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pro;
    }

    public boolean actualizarEstado(String item, String valor, int id) {
        String sql = "UPDATE productos SET " + item + "=? WHERE id=?";
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

    ///LISTAR BITACORAS    
    public List listarBitacora(String valorBusqueda) {
        List<BitProductos> lista = new ArrayList();
        String sql = "SELECT b.*, p.nombre, u.nombre AS usuario FROM bit_productos b INNER JOIN productos p ON b.id_producto = p.id INNER JOIN usuarios u ON b.id_usuario = u.id";
        String busqueda = "SELECT b.*, p.nombre, u.nombre AS usuario FROM bit_productos b INNER JOIN productos p ON b.id_producto = p.id INNER JOIN usuarios u ON b.id_usuario = u.id WHERE b.accion LIKE '%" + valorBusqueda + "%' OR b.campo LIKE '%" + valorBusqueda + "%' OR p.nombre LIKE '%" + valorBusqueda + "%'";
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
            } else {
                ps = con.prepareStatement(busqueda);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                BitProductos pro = new BitProductos();
                pro.setId(rs.getInt("id"));
                pro.setFecha_hora(rs.getString("fecha_hora"));
                pro.setAccion(rs.getString("accion"));
                pro.setCampo(rs.getString("campo"));
                pro.setValor_ant(rs.getString("valor_ant"));
                pro.setValor_nuevo(rs.getString("valor_nuevo"));
                pro.setProducto(rs.getString("nombre"));
                pro.setUsuario(rs.getString("usuario"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public List listarEjemplares(int id_producto, String valorBusqueda) {
        List<Ejemplares> lista = new ArrayList();
        String sql = "SELECT * FROM ejemplares WHERE id_producto = ?";
        String busqueda = "SELECT * FROM ejemplares WHERE nombre LIKE '%" + valorBusqueda + "%' AND id_producto = ?";
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
            } else {
                ps = con.prepareStatement(busqueda);
            }
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplares pro = new Ejemplares();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setEstado(rs.getString("estado"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

}

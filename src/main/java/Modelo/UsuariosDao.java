package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosDao {

    
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    Connection con = cn.getConnection();

    public Usuarios validar(String correo, String pass) {
        Usuarios lg = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ? AND estado = ?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            ps.setInt(3, 1);
            rs = ps.executeQuery();
            if (rs.next()) {
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setAp_paterno(rs.getString("ap_paterno"));
                lg.setAp_materno(rs.getString("ap_materno"));
                lg.setCorreo(rs.getString("correo"));
                lg.setClave(rs.getString("clave"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lg;
    }

    public int registrar(Usuarios cl) {
        int result = 0;
        String sql = "INSERT INTO usuarios (usuario,nombre,ap_paterno,ap_materno,telefono,direccion,correo,clave) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cl.getUsuario());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getAp_paterno());
            ps.setString(4, cl.getAp_materno());
            ps.setString(5, cl.getTelefono());
            ps.setString(6, cl.getDireccion());
            ps.setString(7, cl.getCorreo());
            ps.setString(8, cl.getClave());
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

    public boolean modificar(Usuarios cl) {
        String sql = "UPDATE usuarios SET usuario=?,nombre=?,ap_paterno=?,ap_materno=?,telefono=?,direccion=?,correo=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getUsuario());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getAp_paterno());
            ps.setString(4, cl.getAp_materno());
            ps.setString(5, cl.getTelefono());
            ps.setString(6, cl.getDireccion());
            ps.setString(7, cl.getCorreo());
            ps.setInt(8, cl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List listar(String estado, String valorBusqueda) {
        List<Usuarios> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String status = estado.equals("") ? "" : " WHERE estado = ?";
                String sql = "SELECT * FROM usuarios" + status;
                ps = con.prepareStatement(sql);
            } else {
                String status = estado.equals("") ? "" : " AND estado = ?";
                String busqueda = "SELECT * FROM usuarios WHERE usuario LIKE '%" + valorBusqueda + "%'" + status;
                ps = con.prepareStatement(busqueda);
            }
            if (!estado.equals("")) {
                ps.setString(1, estado);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios cl = new Usuarios();
                cl.setId(rs.getInt("id"));
                cl.setUsuario(rs.getString("usuario"));
                cl.setNombre(rs.getString("nombre"));
                cl.setAp_paterno(rs.getString("ap_paterno"));
                cl.setAp_materno(rs.getString("ap_materno"));
                cl.setCorreo(rs.getString("correo"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setEstado(rs.getString("estado"));
                lista.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public Usuarios buscarUsuario(String id) {
        Usuarios cl = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setId(rs.getInt("id"));
                cl.setUsuario(rs.getString("usuario"));
                cl.setNombre(rs.getString("nombre"));
                cl.setAp_paterno(rs.getString("ap_paterno"));
                cl.setAp_materno(rs.getString("ap_materno"));
                cl.setCorreo(rs.getString("correo"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }

    public String insertarToken(String codigo, String correo) {
        String consulta = "SELECT * FROM usuarios WHERE correo = ?";
        String sql = "UPDATE usuarios SET codigo=? WHERE correo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if (rs.next()) {
                ps = con.prepareStatement(sql);
                ps.setString(1, codigo);
                ps.setString(2, correo);
                ps.execute();
                return "ok";
            } else {
                return "no";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return "error";
        }
    }

    public Usuarios validarCodigo(String correo) {
        Usuarios lg = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND estado = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, "1");
            rs = ps.executeQuery();
            if (rs.next()) {
                lg.setId(rs.getInt("id"));
                lg.setCodigo(rs.getString("codigo"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lg;
    }

    public String modificarClave(String clave, String correo) {
        String sql = "UPDATE usuarios SET clave=? WHERE correo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            ps.setString(2, correo);
            ps.execute();
            return "ok";
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return "error";
        }
    }

    public boolean cerrarConexion() {
        try {
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CERRAR LA CONEXION");
            return false;
        }
    }
}

package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientesDao {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = cn.getConnection();

    public int registrar(Clientes cl) {
        int result = 0;
        String sql = "INSERT INTO clientes (dni,nombre,ap_paterno,ap_materno,f_nac,correo,telefono,movil,direccion,barrio,ciudad,pais,estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getAp_paterno());
            ps.setString(4, cl.getAp_materno());
            ps.setString(5, cl.getF_nacimiento());
            ps.setString(6, cl.getCorreo());
            ps.setString(7, cl.getTelefono());
            ps.setString(8, cl.getMovil());
            ps.setString(9, cl.getDireccion());
            ps.setString(10, cl.getBarrio());
            ps.setString(11, cl.getCiudad());
            ps.setString(12, cl.getPais());
            ps.setString(13, cl.getEstado());
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

    public boolean modificar(Clientes cl) {
        String sql = "UPDATE clientes SET dni=?,nombre=?,ap_paterno=?,ap_materno=?,f_nac=?,correo=?,telefono=?,movil=?,direccion=?,barrio=?,ciudad=?,pais=?,estado=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getAp_paterno());
            ps.setString(4, cl.getAp_materno());
            ps.setString(5, cl.getF_nacimiento());
            ps.setString(6, cl.getCorreo());
            ps.setString(7, cl.getTelefono());
            ps.setString(8, cl.getMovil());
            ps.setString(9, cl.getDireccion());
            ps.setString(10, cl.getBarrio());
            ps.setString(11, cl.getCiudad());
            ps.setString(12, cl.getPais());
            ps.setString(13, cl.getEstado());
            ps.setInt(14, cl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List listar(String estado, String valorBusqueda) {
        List<Clientes> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String status = estado.equals("") ? "" : " WHERE estado = ?";
                String sql = "SELECT * FROM clientes" + status;
                ps = con.prepareStatement(sql);
            } else {
                String status = estado.equals("") ? "" : " AND estado = ?";
                String busqueda = "SELECT * FROM clientes WHERE dni LIKE '%" + valorBusqueda + "%'" + status;
                ps = con.prepareStatement(busqueda);
            }
            if (!estado.equals("")) {
                ps.setString(1, estado);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cl = new Clientes();
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getString("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setAp_paterno(rs.getString("ap_paterno"));
                cl.setAp_materno(rs.getString("ap_materno"));
                cl.setF_nacimiento(rs.getString("f_nac"));
                cl.setCorreo(rs.getString("correo"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setMovil(rs.getString("movil"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setBarrio(rs.getString("barrio"));
                cl.setCiudad(rs.getString("ciudad"));
                cl.setPais(rs.getString("pais"));
                cl.setEstado(rs.getString("estado"));
                lista.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean registrarBitacora(String accion, String campo, String anterior, String nuevo, int id_cliente, int id_usuario) {
        String sql = "INSERT INTO bit_clientes (accion,campo,valor_ant,valor_nuevo,id_cliente,id_usuario) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, accion);
            ps.setString(2, campo);
            ps.setString(3, anterior);
            ps.setString(4, nuevo);
            ps.setInt(5, id_cliente);
            ps.setInt(6, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Clientes buscarCliente(String dni) {
        Clientes cl = new Clientes();
        String sql = "SELECT * FROM clientes WHERE dni = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getString("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setAp_paterno(rs.getString("ap_paterno"));
                cl.setAp_materno(rs.getString("ap_materno"));
                cl.setF_nacimiento(rs.getString("f_nac"));
                cl.setCorreo(rs.getString("correo"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setMovil(rs.getString("movil"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setBarrio(rs.getString("barrio"));
                cl.setCiudad(rs.getString("ciudad"));
                cl.setPais(rs.getString("pais"));
                cl.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }

    public boolean actualizarEstado(String item, String valor, int id) {
        String sql = "UPDATE clientes SET " + item + "=? WHERE id=?";
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
        List<BitClientes> lista = new ArrayList();
        String sql = "SELECT b.*, c.nombre, c.ap_paterno, u.nombre AS usuario FROM bit_clientes b INNER JOIN clientes c ON b.id_cliente = c.id INNER JOIN usuarios u ON b.id_usuario = u.id";
        String busqueda = "SELECT b.*, c.nombre, c.ap_paterno, u.nombre AS usuario FROM bit_clientes b INNER JOIN clientes c ON b.id_cliente = c.id INNER JOIN usuarios u ON b.id_usuario = u.id WHERE b.accion LIKE '%" + valorBusqueda + "%' OR b.campo LIKE '%" + valorBusqueda + "%' OR c.nombre LIKE '%" + valorBusqueda + "%'";
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
            } else {
                ps = con.prepareStatement(busqueda);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                BitClientes cl = new BitClientes();
                cl.setId(rs.getInt("id"));
                cl.setFecha_hora(rs.getString("fecha_hora"));
                cl.setAccion(rs.getString("accion"));
                cl.setCampo(rs.getString("campo"));
                cl.setValor_ant(rs.getString("valor_ant"));
                cl.setValor_nuevo(rs.getString("valor_nuevo"));
                cl.setCliente(rs.getString("nombre") + " " + rs.getString("ap_paterno"));
                cl.setUsuario(rs.getString("usuario"));
                lista.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

}

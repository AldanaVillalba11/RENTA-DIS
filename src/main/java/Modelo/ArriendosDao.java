package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ArriendosDao {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = cn.getConnection();

    public int registrar(Reservas ar) {
        int result = 0;
        String sql = "INSERT INTO arriendos (fecha,obs,estado,id_usuario,id_reserva) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ar.getFecha());
            ps.setString(2, ar.getObservaciones());
            ps.setString(3, ar.getEstado());
            ps.setInt(4, ar.getId_usuario());
            ps.setInt(5, ar.getId());
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
    
    public List listar(String estado, String valorBusqueda) {
        List<Reservas> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String status = estado.equals("") ? "" : " WHERE a.estado = ?";
                String sql = "SELECT a.id, a.obs, a.estado, r.f_inicio, r.f_fin, r.f_devolucion, r.total, c.nombre, c.ap_paterno, c.ap_materno FROM arriendos a INNER JOIN reservas r ON a.id_reserva = r.id INNER JOIN clientes c ON r.id_cliente = c.id" + status;
                ps = con.prepareStatement(sql);
            } else {
                String status = estado.equals("") ? "" : " AND a.estado = ?";
                String busqueda = "SELECT a.id, a.obs, a.estado, r.f_inicio, r.f_fin, r.f_devolucion, r.total, c.nombre, c.ap_paterno, c.ap_materno FROM arriendos a INNER JOIN reservas r ON a.id_reserva = r.id INNER JOIN clientes c ON r.id_cliente = c.id WHERE c.nombre LIKE '%" + valorBusqueda + "%'" + status;
                ps = con.prepareStatement(busqueda);
            }
            if (!estado.equals("")) {
                ps.setString(1, estado);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservas ar = new Reservas();
                ar.setId(rs.getInt("id"));
                ar.setFecha(rs.getString("fecha"));
                ar.setF_inicio(rs.getString("f_inicio"));
                ar.setF_fin(rs.getString("f_fin"));
                ar.setF_devolucion(rs.getString("f_devolucion"));
                ar.setCliente(rs.getString("nombre") + " " + rs.getString("ap_paterno") + " " + rs.getString("ap_materno"));
                ar.setTotal(rs.getInt("total"));
                ar.setObservaciones(rs.getString("obs"));
                ar.setEstado(rs.getString("estado"));
                lista.add(ar);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public boolean actualizarEjemplar(String item, String valor, int id) {
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
    
    public boolean actualizarArriendoEstado(String item, String valor, int id) {
        String sql = "UPDATE arriendos SET " + item + "=? WHERE id=?";
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
        List<BitReservas> lista = new ArrayList();
        String sql = "SELECT b.*, a.id_reserva, u.nombre AS usuario FROM bit_arriendos b INNER JOIN arriendos a ON b.id_arriendo = a.id INNER JOIN usuarios u ON b.id_usuario = u.id";
        String busqueda = "SELECT b.*, a.id_reserva, u.nombre AS usuario FROM bit_arriendos b INNER JOIN arriendos a ON b.id_arriendo = a.id INNER JOIN usuarios u ON b.id_usuario = u.id WHERE b.accion LIKE '%" + valorBusqueda + "%' OR b.campo LIKE '%" + valorBusqueda + "%' OR b.fecha_hora LIKE '%" + valorBusqueda + "%'";
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
            } else {
                ps = con.prepareStatement(busqueda);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                BitReservas pro = new BitReservas();
                
                pro.setId(rs.getInt("id"));
                pro.setFecha_hora(rs.getString("fecha_hora"));
                pro.setAccion(rs.getString("accion"));
                pro.setCampo(rs.getString("campo"));
                pro.setValor_ant(rs.getString("valor_ant"));
                pro.setValor_nuevo(rs.getString("valor_nuevo"));
                pro.setUsuario(rs.getString("usuario"));                
                String sqlCliente = "SELECT c.nombre, c.ap_paterno FROM reservas r INNER JOIN clientes c ON r.id_cliente = c.id WHERE r.id = ?";
                PreparedStatement ps1 = con.prepareStatement(sqlCliente);
                ps1.setInt(1, rs.getInt("id_reserva"));
                ResultSet rs1 = ps1.executeQuery();
                if(rs1.next()){
                    pro.setCliente(rs1.getString("nombre") + " " + rs1.getString("ap_paterno"));
                }
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public void reporteArriendo(int id) {
        String sql = "SELECT r.total, r.otros, c.* FROM reservas r INNER JOIN clientes c ON r.id_cliente = c.id WHERE r.id = ?";
        JasperReport reporte;
        con = cn.getConnection();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Img/logo.png"));
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteArriendo.jasper"));
            Map parametro = new HashMap();

            //obtener datos del cliente
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                parametro.put("nombreEmpresa", "");
                parametro.put("rucEmpresa", "");
                parametro.put("telefonoEmpresa", "");
                parametro.put("direccionEmpresa", "");
                parametro.put("fecha", rs.getString("fecha"));
                parametro.put("id", id);
                parametro.put("docCliente", rs.getString("dni"));
                parametro.put("telefonoCliente", rs.getString("telefono"));
                parametro.put("nombreCliente", rs.getString("nombre") + " " + rs.getString("ap_paterno") + " " + rs.getString("ap_materno"));
                parametro.put("direccionCliente", rs.getString("direccion"));
                parametro.put("logoEmpresa", icon.getImage());
                parametro.put("totalPagar", rs.getDouble("total"));
                parametro.put("otros", rs.getDouble("otros"));
            }
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ArriendosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean actualizarEstado(int id_ejemplar, int id_reserva, int estado) {
        String sql = "UPDATE arriendoproductos SET estado=? WHERE id_ejemplar=? AND id_reserva=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_ejemplar);
            ps.setInt(3, id_reserva);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public int registrarOtros(Cargos cg) {
        int result = 0;
        String sql = "INSERT INTO otroscargos (monto,comentarios,id_arriendo,id_usuario) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, cg.getMonto());
            ps.setString(2, cg.getComentarios());
            ps.setInt(3, cg.getId_arriendo());
            ps.setInt(4, cg.getId_usuario());
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
    
    public List listarCargos(String valorBusqueda) {
        List<Cargos> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String sql = "SELECT c.*, u.nombre, u.ap_paterno, u.ap_materno FROM otroscargos c INNER JOIN usuarios u ON c.id_usuario = u.id";
                ps = con.prepareStatement(sql);
            } else {
                String busqueda = "SELECT c.*, u.nombre, u.ap_paterno, u.ap_materno FROM otroscargos c INNER JOIN usuarios u ON c.id_usuario = u.id WHERE u.nombre LIKE '%" + valorBusqueda + "%'";
                ps = con.prepareStatement(busqueda);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargos ar = new Cargos();
                ar.setId(rs.getInt("id"));
                ar.setFecha(rs.getString("fecha"));
                ar.setMonto(rs.getDouble("monto"));
                ar.setComentarios(rs.getString("comentarios"));
                ar.setUsuario(rs.getString("nombre") + " " + rs.getString("ap_paterno") + " " + rs.getString("ap_materno"));
                lista.add(ar);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public boolean registrarBitacora(String accion, String campo, String anterior, String nuevo, int id_arriendo, int id_usuario) {
        String sql = "INSERT INTO bit_arriendos(accion,campo,valor_ant,valor_nuevo,id_arriendo,id_usuario) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, accion);
            ps.setString(2, campo);
            ps.setString(3, anterior);
            ps.setString(4, nuevo);
            ps.setInt(5, id_arriendo);
            ps.setInt(6, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
}

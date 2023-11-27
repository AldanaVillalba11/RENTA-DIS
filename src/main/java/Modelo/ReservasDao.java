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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReservasDao {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con = cn.getConnection();

    public int registrar(Reservas ar) {
        int result = 0;
        String sql = "INSERT INTO reservas (fecha,f_inicio,f_fin,f_devolucion,total,otros,obs,estado,id_cliente,id_usuario) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ar.getFecha());
            ps.setString(2, ar.getF_inicio());
            ps.setString(3, ar.getF_fin());
            ps.setString(4, ar.getF_devolucion());
            ps.setDouble(5, ar.getTotal());
            ps.setDouble(6, ar.getOtros());
            ps.setString(7, ar.getObservaciones());
            ps.setString(8, ar.getEstado());
            ps.setInt(9, ar.getId_cliente());
            ps.setInt(10, ar.getId_usuario());
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

    public int registrarDetalle(DetalleReservas det) {
        int result = 0;
        String sql = "INSERT INTO arriendoproductos (precio, cantidad, inicio, fin, id_ejemplar,id_reserva) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, det.getPrecio());
            ps.setInt(2, det.getCantidad());
            ps.setString(3, det.getInicio());
            ps.setString(4, det.getFin());
            ps.setInt(5, det.getId_ejemplar());
            ps.setInt(6, det.getId_arriendo());
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

    public boolean modificar(Reservas ar) {
        String sql = "UPDATE reservas SET fecha=?,f_inicio=?,f_fin=?,f_devolucion=?,total=?,otros=?,obs=?,estado=?,id_cliente=?,id_usuario=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ar.getFecha());
            ps.setString(2, ar.getF_inicio());
            ps.setString(3, ar.getF_fin());
            ps.setString(4, ar.getF_devolucion());
            ps.setDouble(5, ar.getTotal());
            ps.setDouble(6, ar.getOtros());
            ps.setString(7, ar.getObservaciones());
            ps.setString(8, ar.getEstado());
            ps.setInt(9, ar.getId_cliente());
            ps.setInt(10, ar.getId_usuario());
            ps.setInt(11, ar.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List listar(String estado, String valorBusqueda) {
        List<Reservas> lista = new ArrayList();
        try {
            if (valorBusqueda.equalsIgnoreCase("")) {
                String status = estado.equals("") ? "" : " WHERE a.estado = ?";
                String sql = "SELECT a.*, c.nombre, c.ap_paterno, c.ap_materno FROM reservas a INNER JOIN clientes c ON a.id_cliente = c.id" + status;
                ps = con.prepareStatement(sql);
            } else {
                String status = estado.equals("") ? "" : " AND a.estado = ?";
                String busqueda = "SELECT a.*, c.nombre, c.ap_paterno, c.ap_materno FROM reservas a INNER JOIN clientes c ON a.id_cliente = c.id WHERE a.id LIKE '%" + valorBusqueda + "%'" + status;
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
                ar.setEstado(rs.getString("estado"));
                lista.add(ar);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean registrarBitacora(String accion, String campo, String anterior, String nuevo, int id_reserva, int id_usuario) {
        String sql = "INSERT INTO bit_reservas(accion,campo,valor_ant,valor_nuevo,id_reserva,id_usuario) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, accion);
            ps.setString(2, campo);
            ps.setString(3, anterior);
            ps.setString(4, nuevo);
            ps.setInt(5, id_reserva);
            ps.setInt(6, id_usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Reservas buscarArriendo(String id) {
        Reservas ar = new Reservas();
        String sql = "SELECT a.*, c.nombre, c.ap_paterno, c.ap_materno FROM reservas a INNER JOIN clientes c ON a.id_cliente = c.id WHERE a.id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ar.setId(rs.getInt("id"));
                ar.setFecha(rs.getString("fecha"));
                ar.setF_inicio(rs.getString("f_inicio"));
                ar.setF_fin(rs.getString("f_fin"));
                ar.setF_devolucion(rs.getString("f_devolucion"));
                ar.setCliente(rs.getString("nombre") + " " + rs.getString("ap_paterno") + " " + rs.getString("ap_materno"));
                ar.setTotal(rs.getDouble("total"));
                ar.setOtros(rs.getDouble("otros"));
                ar.setId_cliente(rs.getInt("id_cliente"));
                ar.setObservaciones(rs.getString("obs"));
                ar.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ar;
    }

    public Usuarios buscarUsuario(int id) {
        Usuarios us = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre") + " " + rs.getString("ap_paterno") + " " + rs.getString("ap_materno"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return us;
    }

    public boolean actualizarEstado(String item, String valor, int id) {
        String sql = "UPDATE reservas SET " + item + "=? WHERE id=?";
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

    public boolean devolucion(String f_devolucion, String estado, int id) {
        String sql = "UPDATE reservas SET f_devolucion=?, estado=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, f_devolucion);
            ps.setString(2, estado);
            ps.setInt(3, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //DETALLES
    public List buscarProducto(String id) {
        List<Productos> lista = new ArrayList();
        String sql = "SELECT a.precio, a.cantidad, a.estado, e.id, e.nombre FROM arriendoproductos a INNER JOIN ejemplares e ON a.id_ejemplar = e.id WHERE a.id_reserva = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("cantidad"));
                pro.setEstado(rs.getString("estado"));
                lista.add(pro);
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

    public boolean eliminarDetalle(String table, int idArriendo) {
        String sql = "DELETE FROM " + table + " WHERE id_reserva = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, idArriendo);
            return ps.execute();
        } catch (SQLException e) {
            return false;
        }
    }

    ///LISTAR BITACORAS    
    public List listarBitacora(String valorBusqueda) {
        List<BitReservas> lista = new ArrayList();
        String sql = "SELECT b.*, c.nombre, u.nombre AS usuario FROM bit_reservas b INNER JOIN reservas r ON b.id_reserva = r.id INNER JOIN clientes c ON r.id_cliente = c.id INNER JOIN usuarios u ON b.id_usuario = u.id";
        String busqueda = "SELECT b.*, c.nombre, u.nombre AS usuario FROM bit_reservas b INNER JOIN reservas r ON b.id_reserva = r.id INNER JOIN clientes c ON r.id_cliente = c.id INNER JOIN usuarios u ON b.id_usuario = u.id WHERE b.accion LIKE '%" + valorBusqueda + "%' OR b.campo LIKE '%" + valorBusqueda + "%' OR c.nombre LIKE '%" + valorBusqueda + "%'";
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
                pro.setCliente(rs.getString("nombre"));
                pro.setUsuario(rs.getString("usuario"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    ///DEVOLUCIONES
    public Reservas buscarComprobante(String id) {
        Reservas ar = new Reservas();
        String sql = "SELECT r.*, c.nombre, c.ap_paterno, c.ap_materno FROM reservas r INNER JOIN clientes c ON r.id_cliente = c.id WHERE r.id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ar.setId(rs.getInt("id"));
                ar.setFecha(rs.getString("fecha"));
                ar.setF_inicio(rs.getString("f_inicio"));
                ar.setF_fin(rs.getString("f_fin"));
                ar.setF_devolucion(rs.getString("f_devolucion"));
                ar.setTotal(rs.getInt("total"));
                ar.setId_cliente(rs.getInt("id_cliente"));
                ar.setCliente(rs.getString("nombre") + " " + rs.getString("ap_paterno") + " " + rs.getString("ap_materno"));
                ar.setObservaciones(rs.getString("obs"));
                ar.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ar;
    }

    public void reporteReserva(int id) {
        String sql = "SELECT r.total, r.otros, c.* FROM reservas r INNER JOIN clientes c ON r.id_cliente = c.id WHERE r.id = ?";
        JasperReport reporte;
        con = cn.getConnection();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Img/logo.png"));
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteReserva.jasper"));
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

    public void filtroReserva(String desde, String hasta) {
        JasperReport reporte;
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Img/logo.png"));
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Reservas.jasper"));
            Map parametro = new HashMap();
            parametro.put("nombreEmpresa", "");
            parametro.put("desde", desde);
            parametro.put("hasta", hasta);
            parametro.put("logoEmpresa", icon.getImage());
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void filtroArriendos(String desde, String hasta) {
        JasperReport reporte;
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Img/logo.png"));
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Arriendos.jasper"));
            Map parametro = new HashMap();
            parametro.put("nombreEmpresa", "");
            parametro.put("desde", desde);
            parametro.put("hasta", hasta);
            parametro.put("logoEmpresa", icon.getImage());
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, con);
            JasperViewer view = new JasperViewer(print, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //BUSCAR RESERVA POR FECHA
    public List getReservas(String inicio, String fin, int id_producto) {
        List<Ejemplares> lista = new ArrayList();
        try {
            // String sql = "SELECT * FROM ejemplares WHERE id NOT IN (SELECT r.id_ejemplar FROM arriendoproductos r WHERE (r.inicio <= ? AND r.fin >= ?) OR (r.fin BETWEEN ? AND ?) OR (r.inicio <= ? AND r.fin >= ?)) AND estado = ? AND id_producto = ?" ;

            String sql = "SELECT * FROM ejemplares WHERE id NOT IN (SELECT r.id_ejemplar FROM arriendoproductos r WHERE (r.inicio <= ? AND r.fin >= ?) OR (r.inicio BETWEEN ? AND ?) OR (r.fin BETWEEN ? AND ?)) AND estado = ? AND id_producto = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, inicio);
            ps.setString(2, fin);
            ps.setString(3, inicio);
            ps.setString(4, fin);
            ps.setString(5, inicio);
            ps.setString(6, fin);
            ps.setString(7, "Disponible");
            ps.setInt(8, id_producto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplares ej = new Ejemplares();
                ej.setId(rs.getInt("id"));
                ej.setNombre(rs.getString("nombre"));
                ej.setEstado(rs.getString("estado"));
                ej.setId_producto(rs.getInt("id_producto"));
                lista.add(ej);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public void reporteGrafico(String anio) {
        String desde = "01-01-" + anio;
        String hasta = "31-12-" + anio;
        try {
            con = cn.getConnection();
            String sql1 = "SELECT SUM(IF(MONTH(fecha) = 1, total, 0)) AS ene, SUM(IF(MONTH(fecha) = 2, total, 0)) AS feb, SUM(IF(MONTH(fecha) = 3, total, 0)) AS mar, SUM(IF(MONTH(fecha) = 4, total, 0)) AS abr, SUM(IF(MONTH(fecha) = 5, total, 0)) AS may, SUM(IF(MONTH(fecha) = 6, total, 0)) AS jun, SUM(IF(MONTH(fecha) = 7, total, 0)) AS jul, SUM(IF(MONTH(fecha) = 8, total, 0)) AS ago, SUM(IF(MONTH(fecha) = 9, total, 0)) AS sep, SUM(IF(MONTH(fecha) = 10, total, 0)) AS oct, SUM(IF(MONTH(fecha) = 11, total, 0)) AS nov, SUM(IF(MONTH(fecha) = 12, total, 0)) AS dic FROM reservas WHERE fecha BETWEEN ? AND ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, desde);
            ps.setString(2, hasta);
            rs = ps.executeQuery();
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            if (rs.next()) {
                ds.addValue(rs.getDouble("ene"), "reservas", "Ene");
                ds.addValue(rs.getDouble("feb"), "reservas", "Feb");
                ds.addValue(rs.getDouble("mar"), "reservas", "Mar");
                ds.addValue(rs.getDouble("abr"), "reservas", "Abr");
                ds.addValue(rs.getDouble("may"), "reservas", "May");
                ds.addValue(rs.getDouble("jun"), "reservas", "Jun");
                ds.addValue(rs.getDouble("jul"), "reservas", "Jul");
                ds.addValue(rs.getDouble("ago"), "reservas", "Ago");
                ds.addValue(rs.getDouble("sep"), "reservas", "Sep");
                ds.addValue(rs.getDouble("oct"), "reservas", "Oct");
                ds.addValue(rs.getDouble("nov"), "reservas", "Nov");
                ds.addValue(rs.getDouble("dic"), "reservas", "Dic");
            }
            JFreeChart jf = ChartFactory.createBarChart3D("COMPARACIÓN DE RESERVAS POR MES", "", "Total", ds, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame f = new ChartFrame("COMPARACIÓN DE RESERVAS POR MES", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void topClientes(String anio) {
        String desde = "01-01-" + anio;
        String hasta = "31-12-" + anio;
        try {
            con = cn.getConnection();
            String sql1 = "SELECT SUM(r.total + r.otros) AS total, u.nombre FROM reservas r INNER JOIN usuarios u ON r.id_usuario = u.id WHERE r.fecha BETWEEN ? AND ? GROUP BY r.id_usuario";
            ps = con.prepareStatement(sql1);
            ps.setString(1, desde);
            ps.setString(2, hasta);
            rs = ps.executeQuery();
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            while (rs.next()) {
                ds.addValue(rs.getDouble("total"), "reservas", rs.getString("nombre"));
            }
            JFreeChart jf = ChartFactory.createBarChart3D("USUARIO CON MÁS RESERVAS", "", "Total", ds, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame f = new ChartFrame("TOP USUARIO", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void topProductos() {
        try {
            con = cn.getConnection();
            String sql1 = "SELECT COUNT(a.id) AS total, e.nombre FROM arriendoproductos a INNER JOIN ejemplares e ON a.id_ejemplar = e.id GROUP BY a.id_ejemplar LIMIT 10";
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            while (rs.next()) {
                ds.addValue(rs.getDouble("total"), "reservas", rs.getString("nombre"));
            }
            JFreeChart jf = ChartFactory.createBarChart3D("PRODUCTOS MAS ARRENDADOS", "", "Total", ds, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame f = new ChartFrame("PRODUCTOS MAS ARRENDADOS", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.toString());
        }
    }
}

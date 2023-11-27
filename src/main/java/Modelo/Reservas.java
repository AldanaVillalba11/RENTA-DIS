
package Modelo;


public class Reservas {
    private int id;
    private String fecha;
    private String f_inicio;
    private String f_fin;
    private String f_devolucion;
    private int id_cliente;
    private String cliente;
    private int id_usuario;
    private String usuario;
    private double total;
    private double otros;
    private String observaciones;
    private String estado;
    
    
    public Reservas(){
        
    }

    public Reservas(int id, String fecha, String f_inicio, String f_fin, String f_devolucion, int id_cliente, String cliente, int id_usuario, String usuario, double total, double otros, String observaciones, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.f_devolucion = f_devolucion;
        this.id_cliente = id_cliente;
        this.cliente = cliente;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.total = total;
        this.otros = otros;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public String getF_fin() {
        return f_fin;
    }

    public void setF_fin(String f_fin) {
        this.f_fin = f_fin;
    }

    public String getF_devolucion() {
        return f_devolucion;
    }

    public void setF_devolucion(String f_devolucion) {
        this.f_devolucion = f_devolucion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getOtros() {
        return otros;
    }

    public void setOtros(double otros) {
        this.otros = otros;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}

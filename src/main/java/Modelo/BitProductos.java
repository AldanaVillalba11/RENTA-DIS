package Modelo;

public class BitProductos {
    private int id;
    private String fecha_hora;
    private String accion;
    private String campo;
    private String valor_ant;
    private String valor_nuevo;    
    private int id_producto;
    private int id_usuario;
    private String producto;
    private String usuario;

    public BitProductos() {
    }

    public BitProductos(int id, String fecha_hora, String accion, String campo, String valor_ant, String valor_nuevo, int id_producto, int id_usuario, String producto, String usuario) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.accion = accion;
        this.campo = campo;
        this.valor_ant = valor_ant;
        this.valor_nuevo = valor_nuevo;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.producto = producto;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValor_ant() {
        return valor_ant;
    }

    public void setValor_ant(String valor_ant) {
        this.valor_ant = valor_ant;
    }

    public String getValor_nuevo() {
        return valor_nuevo;
    }

    public void setValor_nuevo(String valor_nuevo) {
        this.valor_nuevo = valor_nuevo;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    

    
}

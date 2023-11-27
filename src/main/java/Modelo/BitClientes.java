package Modelo;

public class BitClientes {
    private int id;
    private String fecha_hora;
    private String accion;
    private String campo;
    private String valor_ant;
    private String valor_nuevo;    
    private int id_cliente;
    private int id_usuario;
    private String cliente;
    private String usuario;

    public BitClientes() {
    }
    

    public BitClientes(int id, String fecha_hora, String accion, String campo, String valor_ant, String valor_nuevo, int id_cliente, int id_usuario, String cliente, String usuario) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.accion = accion;
        this.campo = campo;
        this.valor_ant = valor_ant;
        this.valor_nuevo = valor_nuevo;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.cliente = cliente;
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
}

package Modelo;

public class BitEjemplares {
    private int id;
    private String fecha_hora;
    private String accion;
    private String campo;
    private String valor_ant;
    private String valor_nuevo;    
    private int id_ejemplar;
    private int id_usuario;
    private String ejemplar;
    private String usuario;

    public BitEjemplares() {
    }

    public BitEjemplares(int id, String fecha_hora, String accion, String campo, String valor_ant, String valor_nuevo, int id_ejemplar, int id_usuario, String ejemplar, String usuario) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.accion = accion;
        this.campo = campo;
        this.valor_ant = valor_ant;
        this.valor_nuevo = valor_nuevo;
        this.id_ejemplar = id_ejemplar;
        this.id_usuario = id_usuario;
        this.ejemplar = ejemplar;
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

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(String ejemplar) {
        this.ejemplar = ejemplar;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
}

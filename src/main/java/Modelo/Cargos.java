package Modelo;

public class Cargos {
    private int id;
    private String fecha;
    private double monto;
    private String comentarios;
    private int id_arriendo;
    private int id_usuario;    
    private String usuario;

    public Cargos() {
    }

    public Cargos(int id, String fecha, double monto, String comentarios, int id_arriendo, int id_usuario, String usuario) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.comentarios = comentarios;
        this.id_arriendo = id_arriendo;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getId_arriendo() {
        return id_arriendo;
    }

    public void setId_arriendo(int id_arriendo) {
        this.id_arriendo = id_arriendo;
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
    
}

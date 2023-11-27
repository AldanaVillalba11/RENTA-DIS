package Modelo;

public class DetalleReservas {
    private int id;
    private int id_arriendo;
    private double precio;
    private int cantidad;
    private int id_ejemplar;
    private String productos;
    private String inicio;
    private String fin;
    

    public DetalleReservas() {
    }

    public DetalleReservas(int id, int id_arriendo, double precio, int cantidad, int id_ejemplar, String productos, String inicio, String fin) {
        this.id = id;
        this.id_arriendo = id_arriendo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_ejemplar = id_ejemplar;
        this.productos = productos;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_arriendo() {
        return id_arriendo;
    }

    public void setId_arriendo(int id_arriendo) {
        this.id_arriendo = id_arriendo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    
}

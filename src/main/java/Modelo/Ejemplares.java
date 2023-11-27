
package Modelo;


public class Ejemplares {
    private int id;
    private String nombre;
    private String geolocalizacion;
    private int stock;
    private int id_producto;
    private String estado;
    
    
    public Ejemplares(){
        
    }

    public Ejemplares(int id, String nombre, String geolocalizacion, int stock, int id_producto, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.geolocalizacion = geolocalizacion;
        this.stock = stock;
        this.id_producto = id_producto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}

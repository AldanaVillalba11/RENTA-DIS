
package Modelo;


public class Productos {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String estado;
    private String ficha_tecnica;
    
    
    public Productos(){
        
    }

    public Productos(int id, String nombre, String descripcion, double precio, int stock, String estado, String ficha_tecnica) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.ficha_tecnica = ficha_tecnica;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFicha_tecnica() {
        return ficha_tecnica;
    }

    public void setFicha_tecnica(String ficha_tecnica) {
        this.ficha_tecnica = ficha_tecnica;
    }

    
    
}

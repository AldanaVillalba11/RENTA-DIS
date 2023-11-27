package Modelo;

public class Clientes {
    private int id;
    private String dni;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String f_nacimiento;    
    private String correo;
    private String telefono;
    private String movil;
    private String direccion;
    private String barrio;
    private String ciudad;
    private String pais;
    private String estado;
    private String fecha;
    private String doc_dni;
    private String doc_boleta;

    public Clientes() {
    }

    public Clientes(int id, String dni, String nombre, String ap_paterno, String ap_materno, String f_nacimiento, String correo, String telefono, String movil, String direccion, String barrio, String ciudad, String pais, String estado, String fecha, String doc_dni, String doc_boleta) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.f_nacimiento = f_nacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.movil = movil;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estado = estado;
        this.fecha = fecha;
        this.doc_dni = doc_dni;
        this.doc_boleta = doc_boleta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDoc_dni() {
        return doc_dni;
    }

    public void setDoc_dni(String doc_dni) {
        this.doc_dni = doc_dni;
    }

    public String getDoc_boleta() {
        return doc_boleta;
    }

    public void setDoc_boleta(String doc_boleta) {
        this.doc_boleta = doc_boleta;
    }
    
    
    
}

package uce.edu.ec.service.to;

public class EstudianteTo {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String cedula;

    public EstudianteTo() {
    }
    public EstudianteTo(Integer id, String nombre, String apellido, String email, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cedula = cedula;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}

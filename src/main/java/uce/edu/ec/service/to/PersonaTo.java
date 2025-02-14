package uce.edu.ec.service.to;

import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlRootElement;
import uce.edu.ec.repository.modelo.LocalDateTimeAdapter;


@XmlRootElement(name = "persona")
public class PersonaTo {

    private Integer id;

    private String nombre;

    private String apellido;

    private LocalDateTime fechaNacimiento;

    private static final long serialVersionUID = -1544399202104638172L;

    public PersonaTo(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;

         
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaTo() {

    }

    // set
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // get
    @XmlElement
    public Integer getId() {
        return id;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public String getApellido() {
        return apellido;
    }

    @XmlElement
    @xmlJavaTypeAdapter(LocalDateTimeAdapter.class)    
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

}

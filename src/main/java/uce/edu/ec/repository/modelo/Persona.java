package uce.edu.ec.repository.modelo;

import java.time.LocalDateTime;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

 
@Entity
@Table(name ="persona")

public class Persona {
 
    @Id
    @SequenceGenerator(name ="sec_persona",sequenceName = "sec_persona",allocationSize = 1 )
    @GeneratedValue(generator = "sec_persona", strategy = GenerationType.SEQUENCE)
    @Column(name = "pers_id")
    private Integer id;
 
    @Column(name = "pers_nombre")
    private String nombre;
 
    @Column(name = "pers_apellido")
    private String apellido;
 
    @Column(name = "pers_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    //set
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
    //get
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    

 
   
}
 
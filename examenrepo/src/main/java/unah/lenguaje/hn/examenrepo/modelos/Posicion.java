package unah.lenguaje.hn.examenrepo.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="posiciones")
public class Posicion {
   
    @Id
    @Column(name = "codigoequipo")
    private int codigoEquipo;
    
    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "codigoequipo")
    private Equipo equipo;
    

    private int empates;
    private int ganados;
    private int perdidos;
    @Column(name="golesfavor")

    private  int golesFavor;
    @Column(name="golescontra")
    private int golesContra;
    private int puntos;
   




    
}

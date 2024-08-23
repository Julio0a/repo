package unah.lenguaje.hn.examenrepo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codigoequipo")
    private int codigoEquipo;

    private String nombre;

    private double ataque;

    private double defensa;
    
}

package unah.lenguaje.hn.examenrepo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguaje.hn.examenrepo.modelos.Posicion;

public interface PosicionRepositorio extends JpaRepository<Posicion ,Integer> {
    
}

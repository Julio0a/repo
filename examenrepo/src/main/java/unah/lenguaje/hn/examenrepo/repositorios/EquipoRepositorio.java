package unah.lenguaje.hn.examenrepo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguaje.hn.examenrepo.modelos.Equipo;

public interface EquipoRepositorio extends JpaRepository<Equipo ,Integer> {
    
}

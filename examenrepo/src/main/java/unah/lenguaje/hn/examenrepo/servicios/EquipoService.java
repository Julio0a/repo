package unah.lenguaje.hn.examenrepo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguaje.hn.examenrepo.modelos.Equipo;
import unah.lenguaje.hn.examenrepo.repositorios.EquipoRepositorio;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepositorio equipoRepositorio;


    public Equipo crearEquipo(Equipo equipo){
        return equipoRepositorio.save(equipo);
    }
    
    

    public String eliminarEquipo(int codigoEquipos) {
        if (equipoRepositorio.existsById(codigoEquipos)) {
            return "no se puede eliminar ";
        }
        equipoRepositorio.deleteById(codigoEquipos);
        return "Equipo eliminado.";
        }

        public String buscarEquipoId(int codigoEquipos){
            if (equipoRepositorio.existsById(codigoEquipos)) {
                return "Equipo encontrado: " + equipoRepositorio.findById(codigoEquipos).get();
            }
            return "No se encontró ";
        }
        

    }


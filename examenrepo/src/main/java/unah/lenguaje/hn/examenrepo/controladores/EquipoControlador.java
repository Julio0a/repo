package unah.lenguaje.hn.examenrepo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguaje.hn.examenrepo.modelos.Equipo;
import unah.lenguaje.hn.examenrepo.servicios.EquipoService;

@RestController
@RequestMapping("/equipos")
public class EquipoControlador {

      @Autowired
    private EquipoService equipoService;

  
    @PostMapping("/crear")
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.crearEquipo(equipo);
    }

    
    @DeleteMapping("/eliminar/{codigoEquipos}")
    public String eliminarEquipo(@PathVariable int codigoEquipos) {
        return equipoService.eliminarEquipo(codigoEquipos);
    }

    @GetMapping("/buscar/{codigoEquipos}")
    public String buscarEquipoId(@PathVariable int codigoEquipos) {
        return equipoService.buscarEquipoId(codigoEquipos);
    }
}

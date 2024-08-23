package unah.lenguaje.hn.examenrepo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguaje.hn.examenrepo.servicios.EquipoService;
@RestController
@RequestMapping("/servicio")
public class ServicioControlador {
    @Autowired private EquipoService equipoService;

   @PostMapping("/simular-partidos")public void simularPartidos() {   
        
    }
     @GetMapping("/tabla-posiciones")public List<Posicion>  {     
          
    }
}

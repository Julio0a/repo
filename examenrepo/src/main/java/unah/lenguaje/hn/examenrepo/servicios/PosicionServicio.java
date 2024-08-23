package unah.lenguaje.hn.examenrepo.servicios;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import unah.lenguaje.hn.examenrepo.modelos.Equipo;
import unah.lenguaje.hn.examenrepo.modelos.Posicion;
import unah.lenguaje.hn.examenrepo.repositorios.EquipoRepositorio;
import unah.lenguaje.hn.examenrepo.repositorios.PosicionRepositorio;

public class PosicionServicio {
    @Autowired
    private EquipoRepositorio equipoRepository;

    @Autowired
    private PosicionRepositorio posicionRepository;

    public void simularPartidos() {
        List<Equipo> equipos = equipoRepository.findAll();

       
        if (equipos.size() < 6) {
            for (int i = equipos.size(); i < 6; i++) {
                Equipo nuevoEquipo = new Equipo();
                nuevoEquipo.setNombre("Equipo " + (i + 1));
                nuevoEquipo.setAtaque(Math.random() * 100);
                nuevoEquipo.setDefensa(Math.random() * 100);
                equipoRepository.save(nuevoEquipo);
            }
            equipos = equipoRepository.findAll();
        }

        Random random = new Random();

     
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipo equipoA = equipos.get(i);
                Equipo equipoB = equipos.get(j);

                
                for (int k = 0; k < 2; k++) {
                    int golesA = random.nextInt(5);
                    int golesB = random.nextInt(5);

                    actualizarPosiciones(equipoA, equipoB, golesA, golesB);
                }
            }
        }
    }

    private void actualizarPosiciones(Equipo equipoA, Equipo equipoB, int golesA, int golesB) {
        Posicion posicionA = posicionRepository.findById(equipoA.getCodigoEquipo())
                .orElse(new Posicion());
        Posicion posicionB = posicionRepository.findById(equipoB.getCodigoEquipo())
                .orElse(new Posicion());

        posicionA.setEquipo(equipoA);
        posicionB.setEquipo(equipoB);

        posicionA.setGolesFavor(posicionA.getGolesFavor() + golesA);
        posicionA.setGolesContra(posicionA.getGolesContra() + golesB);
        posicionB.setGolesFavor(posicionB.getGolesFavor() + golesB);
        posicionB.setGolesContra(posicionB.getGolesContra() + golesA);

        if (golesA > golesB) {
            posicionA.setGanados(posicionA.getGanados() + 1);
            posicionA.setPuntos(posicionA.getPuntos() + 3);
            posicionB.setPerdidos(posicionB.getPerdidos() + 1);
        } else if (golesA < golesB) {
            posicionB.setGanados(posicionB.getGanados() + 1);
            posicionB.setPuntos(posicionB.getPuntos() + 3);
            posicionA.setPerdidos(posicionA.getPerdidos() + 1);
        } else {
            posicionA.setEmpates(posicionA.getEmpates() + 1);
            posicionA.setPuntos(posicionA.getPuntos() + 1);
            posicionB.setEmpates(posicionB.getEmpates() + 1);
            posicionB.setPuntos(posicionB.getPuntos() + 1);
        }

        posicionRepository.save(posicionA);
        posicionRepository.save(posicionB);
    }
    public List<Posicion> obtenerTablaPosiciones() {
        return posicionRepository.findAll();
    }
}

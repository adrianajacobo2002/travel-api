package com.example.travel_api.Service;

import com.example.travel_api.entity.Vuelo;
import com.example.travel_api.interfaces.vueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VueloService {
    @Autowired
    private vueloRepository repository;

    public List<Vuelo> buscarVuelos(int origen, int destino, LocalDateTime fecha_salida, LocalDateTime fecha_regreso,
                                    Vuelo.TipoVuelo tipoVuelo, Integer aerolinea) {
        return repository.buscarVuelos(origen, destino, fecha_salida, fecha_regreso, tipoVuelo, aerolinea);
    }

    public Optional<Vuelo> obtenerVueloPorId(int id) {
        return repository.findById(id);
    }

    public Vuelo crearVuelo(Vuelo vuelo) {
        return repository.save(vuelo);
    }

    public Vuelo actualizarVuelo(int id, Vuelo nuevoVuelo) {
        return repository.findById(id).map(vuelo -> {
            vuelo.setAerolinea(nuevoVuelo.getAerolinea());
            vuelo.setNumero_vuelo(nuevoVuelo.getNumero_vuelo());
            vuelo.setOrigen(nuevoVuelo.getOrigen());
            vuelo.setDestino(nuevoVuelo.getDestino());
            vuelo.setFecha_salida(nuevoVuelo.getFecha_salida());
            vuelo.setFecha_regreso(nuevoVuelo.getFecha_regreso());
            vuelo.setDuracion(nuevoVuelo.getDuracion());
            vuelo.setPrecio_base(nuevoVuelo.getPrecio_base());
            vuelo.setTipo_vuelo(nuevoVuelo.getTipo_vuelo());
            vuelo.setId_vuelo_regreso(nuevoVuelo.getId_vuelo_regreso());
            return repository.save(vuelo);
        }).orElseThrow(()-> new RuntimeException("No se encontro el registro"));

    }

    public void eliminarVuelo(int id) {
        repository.deleteById(id);
    }
}

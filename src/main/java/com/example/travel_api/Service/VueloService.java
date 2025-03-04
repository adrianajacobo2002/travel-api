package com.example.travel_api.Service;

import com.example.travel_api.entity.Vuelo;
import com.example.travel_api.interfaces.vueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class VueloService {
    @Autowired
    private vueloRepository repository;

    public List<Vuelo> buscarVuelos(int origen, int destino, LocalDateTime fecha_salida, LocalDateTime fecha_regreso,
                                    Vuelo.TipoVuelo tipoVuelo, Integer aerolinea) {
        return repository.buscarVuelos(origen, destino, fecha_salida, fecha_regreso, tipoVuelo, aerolinea);
    }

    public List<Vuelo> buscarVuelosDirectos(int origen,
                                            int destino,
                                            LocalDateTime fecha_salida,
                                            LocalDateTime fecha_regreso,
                                            Vuelo.TipoVuelo tipoVuelo,
                                            Integer aerolinea) {
        List<Vuelo> vuelos = repository.buscarVuelosDirectos(origen, destino, fecha_salida, fecha_regreso, tipoVuelo, aerolinea);

        for (Vuelo v : vuelos) {
            System.out.println("Vuelo: " + v.getNumero_vuelo() + ", Clases: " + v.getClases());
        }
        return vuelos;
    }

    public List<Map<String, Vuelo>> buscarVuelosEscalas(int origen,
                                            int destino,
                                            LocalDateTime fecha_salida,
                                            LocalDateTime fecha_regreso,
                                            Vuelo.TipoVuelo tipoVuelo,
                                            Integer aerolinea) {
        List<Object[]> resultados = repository.buscarVuelosEscalas(origen, destino, fecha_salida, fecha_regreso, tipoVuelo, aerolinea);
        List<Map<String, Vuelo>> vuelosConEscalas = new ArrayList<>();

        for (Object[] fila : resultados) {
            Vuelo vueloPrincipal = (Vuelo) fila[0];
            Vuelo vueloEscala = (Vuelo) fila[1];

            Map<String, Vuelo> vueloMap = new HashMap<>();
            vueloMap.put("vuelo_principal", vueloPrincipal);
            vueloMap.put("vuelo_escala", vueloEscala);
            vuelosConEscalas.add(vueloMap);
        }

        return vuelosConEscalas;
    }

    public List<Object> buscarVuelosEscalasyDirectos(int origen,
                                                     int destino,
                                                     LocalDateTime fecha_salida,
                                                     LocalDateTime fecha_regreso,
                                                     Vuelo.TipoVuelo tipoVuelo,
                                                     Integer aerolinea) {
        List<Object> resultado = new ArrayList<>();

        List<Vuelo> vuelosDirectos = repository.buscarVuelosDirectosoEscalas(origen, destino, fecha_salida, fecha_regreso, tipoVuelo, aerolinea);
        System.out.println("Vuelos directos encontrados: " + vuelosDirectos.size());
        List<Object[]> vuelosconEscalas = repository.buscarVuelosEscalas(origen, destino, fecha_salida, fecha_regreso, tipoVuelo, aerolinea);
        System.out.println("Vuelos con escalas encontrados: " + vuelosconEscalas.size());
        for (Object[] vuelo : vuelosconEscalas) {
            Map<String, Object> vueloConEscala = new HashMap<>();
            vueloConEscala.put("vuelo_principal", vuelo[0]);
            vueloConEscala.put("vuelo_escala", vuelo[1]);
            resultado.add(vueloConEscala);
        }

        resultado.addAll(vuelosDirectos);

        return resultado;
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
            vuelo.setVueloRegreso(nuevoVuelo.getVueloRegreso());
            return repository.save(vuelo);
        }).orElseThrow(()-> new RuntimeException("No se encontro el registro"));
    }

    public void eliminarVuelo(int id) {
        repository.deleteById(id);
    }
}

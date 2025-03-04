package com.example.travel_api.controller;

import com.example.travel_api.Service.VueloService;
import com.example.travel_api.entity.Vuelo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
    @Autowired
    private VueloService vueloService;

    @GetMapping("/buscar")
    public List<Vuelo> buscarVuelos(
            @RequestParam int origen,
            @RequestParam int destino,
            @RequestParam String fechaSalida,
            @RequestParam(required = false) String fechaRegreso,
            @RequestParam(required = false) Vuelo.TipoVuelo tipoVuelo,
            @RequestParam(required = false) Integer aerolinea
            ) {
        LocalDateTime salida = LocalDateTime.parse(fechaSalida);
        LocalDateTime regreso = (fechaRegreso != null) ? LocalDateTime.parse(fechaRegreso) : null;
        return vueloService.buscarVuelos(origen, destino, salida, regreso, tipoVuelo, aerolinea);
    }

    @GetMapping("/{id}")
    public Optional<Vuelo> obtenerVuelo(@PathVariable int id) {
        return vueloService.obtenerVueloPorId(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.crearVuelo(vuelo);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public Vuelo actualizarVuelo(@PathVariable int id, @RequestBody Vuelo vuelo) {
        return vueloService.actualizarVuelo(id, vuelo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public void eliminarVuelo(@PathVariable int id) {
        vueloService.eliminarVuelo(id);
    }
}

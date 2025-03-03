package com.example.travel_api.Service;

import com.example.travel_api.entity.Aerolinea;
import com.example.travel_api.interfaces.aerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaService {

    @Autowired
    private aerolineaRepository repository;

    public List<Aerolinea> getAllAerolinea(){
        return repository.findAll();
    }

    public Optional<Aerolinea> getAerolineaById(int id){
        return repository.findById(id);
    }

    public Aerolinea crearAerolinea(Aerolinea aerolinea){
        return repository.save(aerolinea);
    }

    public Aerolinea actualizarAerolinea(int id, Aerolinea nuevaaerolinea){
        return repository.findById(id).map(aerolinea -> {
            aerolinea.setNombre(nuevaaerolinea.getNombre());
            aerolinea.setCodigo_aerolinea(nuevaaerolinea.getCodigo_aerolinea());
            return repository.save(aerolinea);
        }).orElseThrow(()-> new RuntimeException("Aerolinea no encontrada"));
    }

    public void eliminarAerolinea(int id){
        repository.deleteById(id);
    }


}

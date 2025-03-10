package com.example.travel_api.security;

import com.example.travel_api.entity.Usuario;
import com.example.travel_api.interfaces.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    @Autowired
    private usuarioRepository usuariorepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuariorepository.findByEmail(email);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new org.springframework.security.core.userdetails.User(
                usuario.get().getEmail(),
                usuario.get().getContrasena(),
                new ArrayList<>()
        );
    }


}

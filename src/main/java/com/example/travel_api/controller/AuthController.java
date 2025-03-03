package com.example.travel_api.controller;

import com.example.travel_api.Service.UsuarioService;
import com.example.travel_api.entity.Usuario;
import com.example.travel_api.interfaces.usuarioRepository;
import com.example.travel_api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private usuarioRepository usuariorepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Usuario usuario) {
        Map<String, String> response = new HashMap<>();

        if (usuariorepository.existsByEmail(usuario.getEmail())) {
            response.put("message", "El email ya está en uso");
            return response;
        }

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuariorepository.save(usuario);

        response.put("message", "Usuario registrado correctamente");
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario usuario) {
        System.out.println("Usuario recibido: " + usuario);
        Optional<Usuario> user = usuariorepository.findByEmail(usuario.getEmail());

        if (user.isPresent()  && passwordEncoder.matches(usuario.getContrasena(), user.get().getContrasena())) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getContrasena()));
            String token = jwtUtil.generateToken(user.get().getEmail(), user.get().getTipo_usuario().name());

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("rol", user.get().getTipo_usuario().name());
            return response;
        }else{
            throw new RuntimeException("Credenciales incorrectas");
        }
    }

}

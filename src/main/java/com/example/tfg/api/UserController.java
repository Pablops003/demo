    package com.example.tfg.api;

    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.provisioning.UserDetailsManager;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/usuarios")
    public class UserController {
        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        @Autowired
        private UserDetailsManager userDetailsManager;

        @Autowired
        private UsuarioRepository repo;

        @GetMapping("/all")
        List<Usuario> getAll() {
            return repo.findAll();
        }

        @PostMapping("/register/")
        public String register(@Valid @RequestBody UserRegisterRequest userRegisterRequest) {
            System.out.println(userRegisterRequest);
            if (userDetailsManager.userExists(userRegisterRequest.getUsername())) {
                return "ERROR: l'usuari ja existeix";
            }

            userDetailsManager.createUser(User.builder()
                    .username(userRegisterRequest.getUsername())
                    .password(passwordEncoder.encode(userRegisterRequest.getPassword()))
                    .roles("USER")
                    .build()
            );
            return "OK";
        }

        // Endpoint para validar login (usuario autenticado)
//        @GetMapping("/me")
//        public String getCurrentUser(@AuthenticationPrincipal User user) {
//            return user.getUsername();
//        }

        // En UsuarioController.java
        @GetMapping("/me")
        public ResponseEntity<UsuarioDTO> getDatosUsuario(Authentication auth) {
            Usuario user = repo.findByUsername(auth.getName());
            return ResponseEntity.ok(new UsuarioDTO(user.getId(), user.getUsername()));
        }


//        @GetMapping("/login")
//        public String login(){
//            return "OK";
//        }

//        @PostMapping("/registro")
//        public Usuario registrar(@RequestBody Usuario u) {
//            return repo.save(u);
//        }

//        @PostMapping("/login")
//        public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
//            String correo = datos.get("correo");
//            String contrasena = datos.get("contrasena");
//
//            Optional<Usuario> u = repo.findByCorreo(correo);
//            if (u.isPresent() && u.get().password.equals(contrasena)) {
//                return ResponseEntity.ok(u.get());
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No es valido");
//            }
//        }
    }


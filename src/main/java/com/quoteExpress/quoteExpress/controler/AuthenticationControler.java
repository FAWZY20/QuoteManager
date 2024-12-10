package com.quoteExpress.quoteExpress.controler;


import com.quoteExpress.quoteExpress.model.Utilisateur;
import com.quoteExpress.quoteExpress.repository.UtilisateurRepository;
import com.quoteExpress.quoteExpress.service.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationControler {

    private final PasswordEncoder passwordEncoder;

    private final UtilisateurRepository utilisateurRepository;
    private final JwtUtils jwtUtils;

    public AuthenticationControler(PasswordEncoder passwordEncoder, UtilisateurRepository utilisateurRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public  ResponseEntity<?> authenticateUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur uti = utilisateurRepository.findByEmail(utilisateur.getEmail());

        if (!passwordEncoder.matches(utilisateur.getMdp(), uti.getMdp())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
        }

        String token = jwtUtils.generateToken(utilisateur.getEmail());

        return ResponseEntity.ok(token);
    }
}

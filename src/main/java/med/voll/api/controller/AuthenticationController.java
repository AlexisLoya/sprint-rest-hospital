package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.users.User;
import med.voll.api.domain.users.dto.UserAuth;
import med.voll.api.infra.security.TokenService;
import med.voll.api.infra.security.dto.JWTData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity<JWTData> login(@RequestBody @Valid UserAuth userAuth) {
        Authentication token = new UsernamePasswordAuthenticationToken(userAuth.email(), userAuth.password());
        var userAuthenticated = authenticationManager.authenticate(token);
        var user = (User) userAuthenticated.getPrincipal();
        return ResponseEntity.ok(new JWTData(tokenService.generateToken(user)));
    }
}

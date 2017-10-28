package com.hackcrashfiasco.letMeComplainFiasco.controller;


import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthenticationRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthorisationToken;
import com.hackcrashfiasco.letMeComplainFiasco.service.AuthorisationService;
import com.hackcrashfiasco.letMeComplainFiasco.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthorisationController {



    private JWTService jwtService;
    private AuthorisationService authorisationService;

    @Autowired
    public AuthorisationController(JWTService jwtService, AuthorisationService authorisationService) {
        this.jwtService = jwtService;
        this.authorisationService = authorisationService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public String authenticate(@RequestBody AuthenticationRepresentation authenticationRepresentation){
        AuthorisationToken token = authorisationService.authenticateUser(authenticationRepresentation);
        return jwtService.generateToken(token);
    }
}

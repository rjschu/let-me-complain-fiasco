package com.hackcrashfiasco.letMeComplainFiasco.controller;


import com.hackcrashfiasco.letMeComplainFiasco.domain.TwoFactor;
import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthenticationRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthorisationToken;
import com.hackcrashfiasco.letMeComplainFiasco.service.AuthorisationService;
import com.hackcrashfiasco.letMeComplainFiasco.service.JWTService;
import com.hackcrashfiasco.letMeComplainFiasco.service.TwoFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthorisationController {



    private JWTService jwtService;
    private AuthorisationService authorisationService;
    private TwoFactorService twoFactorService;


    @Autowired
    public AuthorisationController(JWTService jwtService, AuthorisationService authorisationService, TwoFactorService twoFactorService) {
        this.jwtService = jwtService;
        this.authorisationService = authorisationService;
        this.twoFactorService = twoFactorService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public String authenticate(@RequestBody AuthenticationRepresentation authenticationRepresentation){
        User token = authorisationService.authenticateUser(authenticationRepresentation);
        final TwoFactor twoFactor = twoFactorService.sendInitialTwoFactorSms(token.getTelephoneNumber());
        twoFactor.setEmailAddress(token.getEmailAddress());

        return jwtService.generateToken(twoFactor);
    }

}

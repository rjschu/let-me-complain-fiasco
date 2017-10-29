package com.hackcrashfiasco.letMeComplainFiasco.controller;

import com.hackcrashfiasco.letMeComplainFiasco.controller.exceptions.NotAuthorisedException;
import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthorisationToken;
import com.hackcrashfiasco.letMeComplainFiasco.representations.TwoFactorRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.service.JWTService;
import com.hackcrashfiasco.letMeComplainFiasco.service.TwoFactorService;
import com.hackcrashfiasco.letMeComplainFiasco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/two-factor")
public class TwoFactorController {

    private TwoFactorService twoFactorService;
    private UserService userService;
    private JWTService jwtService;


    @Autowired
    public TwoFactorController(TwoFactorService twoFactorService, UserService userService, JWTService jwtService) {
        this.twoFactorService = twoFactorService;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String validateTwoFactorCode(@RequestBody TwoFactorRepresentation twoFactorRepresentation){
        if(twoFactorService.isTwoFactorValid(twoFactorRepresentation.getCode(),twoFactorRepresentation.getTelephoneNumber())){
            User user = userService.findUserByTelephoneNumber(twoFactorRepresentation.getTelephoneNumber());
            return jwtService.generateToken(new AuthorisationToken(user));
        }else{
            throw new NotAuthorisedException();
        }
    }
}

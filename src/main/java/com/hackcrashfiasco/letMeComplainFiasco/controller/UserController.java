package com.hackcrashfiasco.letMeComplainFiasco.controller;


import com.hackcrashfiasco.letMeComplainFiasco.controller.exceptions.NotFoundException;
import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.representations.CreateUserRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.representations.UserRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserRepresentation createUser(@RequestBody CreateUserRepresentation userToCreate){
        User createdUser = userService.createUser(new User(userToCreate));
        return new UserRepresentation(createdUser);
    }

    @RequestMapping(method = RequestMethod.GET)
    public UserRepresentation findUserByEmailAddress(@RequestParam String emailAddress){
        User user = userService.findUserByEmailAddress(emailAddress);
        return new UserRepresentation(user);
    }

}

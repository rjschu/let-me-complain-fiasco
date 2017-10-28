package com.hackcrashfiasco.letMeComplainFiasco.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hackcrashfiasco.letMeComplainFiasco.controller.exceptions.NotAuthorisedException;
import com.hackcrashfiasco.letMeComplainFiasco.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorisationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!request.getPathInfo().contains("auth") ||
               (request.getPathInfo().contains("user") && request.getMethod().equalsIgnoreCase("post"))){
            String header = request.getHeader("Authorization");
            if(header != null){
                try {
                    jwtService.validateToken(header);
                }catch(JWTVerificationException ex){
                    throw new NotAuthorisedException();
                }
            }else{
                throw new NotAuthorisedException();
            }
        }
        return true;
    }
}

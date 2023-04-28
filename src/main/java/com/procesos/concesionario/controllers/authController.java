package com.procesos.concesionario.controllers;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class authController {
    private UserService userService;
    private Map response;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        response = new HashMap<>();
        try {
            response.put("message","usuario encontrado");
            response.put("token",userService.login(user));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("message",e.getMessage());
            return new ResponseEntity(response,HttpStatus.NO_CONTENT);
        }
    }
}

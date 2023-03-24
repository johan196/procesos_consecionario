package com.procesos.concesionario.controllers;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserService;
import com.procesos.concesionario.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping(value = "/user/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id){
        Map response = new HashMap();
      try{
          response.put("message","Se encontro el usuario");
          response.put("data",userServiceImp.getUserById(id));
          return new ResponseEntity(response,HttpStatus.OK);
      }catch (Exception e){
          response.put("message","no se encontro el usuario");
          response.put("data",e.getMessage());
          return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
      }


    }


    @GetMapping(value = "/users")
    public ResponseEntity getByAllUsers(){
        Map response = new HashMap();
        try{
            response.put("message","Se encontraron a todos los usuarios");
            response.put("data",userServiceImp.allUser());
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.put("message","no se encontraron los usuarios");
            response.put("data",e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }


    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity Edituser(@PathVariable(name = "id") Long id,User user){
        Map response = new HashMap();
        try{
            response.put("message","Se actualizo el usuario");
            response.put("data",userServiceImp.updateUser(id,user));
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.put("message","no se altualizo el usuario");
            response.put("data",e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }


    }


}

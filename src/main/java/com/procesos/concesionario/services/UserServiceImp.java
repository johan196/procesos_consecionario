package com.procesos.concesionario.services;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.repository.UserRepository;
import com.procesos.concesionario.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public User getUserById( Long id){return userRepository.findById(id).get();
    }

    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(long id, User user) {
        User userBD=userRepository.findById(id).get();
        userBD.setFistname(user.getFistname());
        userBD.setLastname(user.getLastname());
        userBD.setAddress(user.getAddress());
        userBD.setBirtday(user.getBirtday());
        return userRepository.save(userBD) ;
    }



    @Override
    public String login(User user) {
        Optional<User> userBd = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(userBd.isEmpty()){
            throw new RuntimeException("usuario no encontrado");
        }
        return jwtUtil.create(String.valueOf(userBd.get().getId()),String.valueOf(userBd.get().getEmail()));
    }

}

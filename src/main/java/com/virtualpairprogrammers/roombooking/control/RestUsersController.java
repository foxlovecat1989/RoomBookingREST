package com.virtualpairprogrammers.roombooking.control;

import com.virtualpairprogrammers.roombooking.data.UserRepository;
import com.virtualpairprogrammers.roombooking.model.entities.AngularUser;
import com.virtualpairprogrammers.roombooking.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/users")
public class RestUsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    List<AngularUser> findAllUsers(){
        return userRepository.findAll().stream().map(AngularUser::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    AngularUser findUserById(@PathVariable("id") Long id){
        return new AngularUser(userRepository.findById(id).get());
    }

    @PostMapping
    AngularUser createUser(@RequestBody AngularUser angularUser){
        return new AngularUser(userRepository.save(angularUser.toUser()));
    }

    @PutMapping
    AngularUser updateUser(@RequestBody AngularUser angularUser){
        User origin = userRepository.findById(angularUser.getId()).get();
        origin.setName(angularUser.getName());

        return new AngularUser(userRepository.save(origin));
    }


}

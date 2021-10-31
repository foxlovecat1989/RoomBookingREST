package com.virtualpairprogrammers.roombooking.model.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AngularUser {
    private Long id;
    private String name;

    public AngularUser(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword("");

        return user;
    }
}

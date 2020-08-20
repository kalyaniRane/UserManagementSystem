package com.usermanagement.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    int id;
    String name;
    String email;
    String password;

    public UserDto(int id,String name, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }
}

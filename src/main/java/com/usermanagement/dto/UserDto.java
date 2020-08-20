package com.usermanagement.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    public int id;
    public String name;
    public String email;
    public String password;

    public UserDto(int id,String name, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }
}

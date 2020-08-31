package com.usermanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDto implements Serializable {

    public Long id;
    public String name;
    public String email;
    public String password;

    public UserDto(Long id,String name, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }
}

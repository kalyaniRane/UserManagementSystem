package com.usermanagement.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

    public String userName;
    public String password;

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}

package com.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class LoginDto implements Serializable {

    private String userName;
    private String password;

}

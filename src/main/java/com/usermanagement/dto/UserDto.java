package com.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;
import java.io.Serializable;


@Getter
@Setter
public class UserDto implements Serializable {

    private String name;
    private Long id;
    private String email;
    private String password;
    private String userRole;
    private String dateOfBirth;
    private InputStream userProfileImage;

    private String userImage;

}

package com.usermanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.InputStream;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class NewUserDto implements Serializable {

    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String country;
    private String countryCode;
    private Long mobileNumber;
    private InputStream userImage;
    private String userName;
    private String password;
    private String emailId;
    private String userRole;
    private String address;

}

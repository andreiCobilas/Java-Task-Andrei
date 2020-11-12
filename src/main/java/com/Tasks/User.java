package com.Tasks;

import java.util.Date;
import java.util.List;

public class User {

    private String userId;
    private String userFirstName;
    private String userLastName;
    private String birthCity;
    private Date birthDate;


    public User(String userId, String userFirstName, String userLastName, String birthCity, Date birthDate) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.birthCity = birthCity;
        this.birthDate = birthDate;
    }

    public String getUserId() {
        return userId;
    }

    /** Constructors used for unit testing*/
    public User(String userId) {
        this.userId = userId;
    }

}

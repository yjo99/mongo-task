package com.sarmad.task.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "USERS")
public class User {
    @Id
    private String user_id;

    @Field("first_name")
    private String firstName;

    @Field("second_name")
    private String secondName;

    @Field("login_id")
    private String loginID;

    @Field("password")
    private String password;
}

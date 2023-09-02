package org.matveev.librarymanagementuserservice.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String password_hash;
    private String date_joined;

}

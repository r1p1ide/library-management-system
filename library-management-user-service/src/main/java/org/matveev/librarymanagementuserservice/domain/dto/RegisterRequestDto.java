package org.matveev.librarymanagementuserservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequestDto {

    private String name;
    private String email;
    private String password_hash;
    private String date_joined;

}

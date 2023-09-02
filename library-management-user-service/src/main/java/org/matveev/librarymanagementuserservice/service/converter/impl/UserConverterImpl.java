package org.matveev.librarymanagementuserservice.service.converter.impl;

import org.matveev.librarymanagementuserservice.domain.dto.RegisterRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.UpdateRequestDto;
import org.matveev.librarymanagementuserservice.domain.entity.User;
import org.matveev.librarymanagementuserservice.service.converter.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User convert(RegisterRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password_hash(dto.getPassword_hash())
                .date_joined(dto.getDate_joined())
                .build();
    }

    @Override
    public User convert(UpdateRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password_hash(dto.getPassword_hash())
                .date_joined(dto.getDate_joined())
                .build();
    }

}

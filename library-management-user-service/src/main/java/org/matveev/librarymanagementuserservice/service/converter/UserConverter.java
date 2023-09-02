package org.matveev.librarymanagementuserservice.service.converter;

import org.matveev.librarymanagementuserservice.domain.dto.RegisterRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.UpdateRequestDto;
import org.matveev.librarymanagementuserservice.domain.entity.User;

public interface UserConverter {

    User convert(RegisterRequestDto dto);

    User convert(UpdateRequestDto dto);
}

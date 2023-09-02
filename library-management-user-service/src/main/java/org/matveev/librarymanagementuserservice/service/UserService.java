package org.matveev.librarymanagementuserservice.service;

import org.matveev.librarymanagementuserservice.domain.dto.DeleteRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.RegisterRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.UpdateRequestDto;

public interface UserService {

    void register(RegisterRequestDto dto);

    void delete(DeleteRequestDto dto);

    void update(UpdateRequestDto dto);
}

package org.matveev.librarymanagementuserservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.matveev.librarymanagementuserservice.domain.dto.DeleteRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.RegisterRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.UpdateRequestDto;
import org.matveev.librarymanagementuserservice.repository.UserRepository;
import org.matveev.librarymanagementuserservice.service.UserService;
import org.matveev.librarymanagementuserservice.service.converter.UserConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter converter;

    @Override
    public void register(RegisterRequestDto dto) {
        log.info("Start REGISTER process");

        userRepository.save(
                converter.convert(dto)
        );

        log.info("End REGISTER process");
    }

    @Override
    public void delete(DeleteRequestDto dto) {
        log.info("Start DELETE process");

        userRepository.delete(dto.getId());

        log.info("End DELETE process");
    }

    @Override
    public void update(UpdateRequestDto dto) {
        log.info("Start UPDATE process");

        userRepository.update(
                converter.convert(dto)
        );

        log.info("End UPDATE process");
    }

}

package org.matveev.librarymanagementuserservice.grpc.converter.impl;

import org.matveev.librarymanagementuserservice.domain.dto.DeleteRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.RegisterRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.UpdateRequestDto;
import org.matveev.librarymanagementuserservice.grpc.converter.ProtoToDtoConverter;
import org.matveev.librarymanagementuserservice.proto.DeleteRequest;
import org.matveev.librarymanagementuserservice.proto.RegisterRequest;
import org.matveev.librarymanagementuserservice.proto.UpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class ProtoToDtoConverterImpl implements ProtoToDtoConverter {

    @Override
    public RegisterRequestDto convert(RegisterRequest request) {
        var user = request.getUser();
        return RegisterRequestDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password_hash(user.getPasswordHash())
                .date_joined(user.getDateJoined())
                .build();
    }

    @Override
    public DeleteRequestDto convert(DeleteRequest request) {
        return DeleteRequestDto.builder()
                .id(request.getId())
                .build();
    }

    @Override
    public UpdateRequestDto convert(UpdateRequest request) {
        var user = request.getUser();
        return UpdateRequestDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password_hash(user.getPasswordHash())
                .date_joined(user.getDateJoined())
                .build();
    }

}

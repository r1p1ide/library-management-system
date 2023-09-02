package org.matveev.librarymanagementuserservice.grpc.handler.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.librarymanagementuserservice.grpc.converter.ProtoToDtoConverter;
import org.matveev.librarymanagementuserservice.grpc.handler.UserServiceRequestHandler;
import org.matveev.librarymanagementuserservice.proto.DeleteRequest;
import org.matveev.librarymanagementuserservice.proto.RegisterRequest;
import org.matveev.librarymanagementuserservice.proto.UpdateRequest;
import org.matveev.librarymanagementuserservice.service.UserService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceRequestHandlerImpl implements UserServiceRequestHandler {

    private final UserService userService;
    private final ProtoToDtoConverter converter;

    @Override
    public void handleRequest(RegisterRequest request) {
        userService.register(
                converter.convert(request)
        );
    }

    @Override
    public void handleRequest(DeleteRequest request) {
        userService.delete(
                converter.convert(request)
        );
    }

    @Override
    public void handleRequest(UpdateRequest request) {
        userService.update(
                converter.convert(request)
        );
    }

}

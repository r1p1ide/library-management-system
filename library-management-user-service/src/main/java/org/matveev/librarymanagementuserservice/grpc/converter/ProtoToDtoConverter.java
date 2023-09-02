package org.matveev.librarymanagementuserservice.grpc.converter;

import org.matveev.librarymanagementuserservice.domain.dto.DeleteRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.RegisterRequestDto;
import org.matveev.librarymanagementuserservice.domain.dto.UpdateRequestDto;
import org.matveev.librarymanagementuserservice.proto.DeleteRequest;
import org.matveev.librarymanagementuserservice.proto.RegisterRequest;
import org.matveev.librarymanagementuserservice.proto.UpdateRequest;

public interface ProtoToDtoConverter {

    RegisterRequestDto convert(RegisterRequest request);

    DeleteRequestDto convert(DeleteRequest request);

    UpdateRequestDto convert(UpdateRequest request);
}

package org.matveev.librarymanagementbookservice.grpc.converter;

import org.matveev.librarymanagementbookservice.domain.dto.*;
import org.matveev.librarymanagementbookservice.proto.AddRequest;
import org.matveev.librarymanagementbookservice.proto.DeleteRequest;
import org.matveev.librarymanagementbookservice.proto.GetRequest;
import org.matveev.librarymanagementbookservice.proto.SearchRequest;
import org.matveev.librarymanagementbookservice.proto.UpdateRequest;

public interface ProtoToDtoConverter {

    AddRequestDto convert(AddRequest request);

    DeleteRequestDto convert(DeleteRequest request);

    UpdateRequestDto convert(UpdateRequest request);

    GetRequestDto convert(GetRequest request);

    SearchRequestDto convert(SearchRequest request);
}

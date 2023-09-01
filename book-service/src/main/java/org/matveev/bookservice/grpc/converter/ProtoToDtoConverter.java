package org.matveev.bookservice.grpc.converter;

import org.matveev.bookservice.domain.dto.*;
import org.matveev.bookservice.proto.*;

public interface ProtoToDtoConverter {

    AddRequestDto convert(AddRequest request);

    DeleteRequestDto convert(DeleteRequest request);

    UpdateRequestDto convert(UpdateRequest request);

    GetRequestDto convert(GetRequest request);

    SearchRequestDto convert(SearchRequest request);
}

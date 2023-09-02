package org.matveev.librarymanagementbookservice.grpc.converter;

import org.matveev.librarymanagementbookservice.domain.dto.*;
import org.matveev.librarymanagementbookservice.proto.GetResponse;
import org.matveev.librarymanagementbookservice.proto.SearchResponse;

public interface DtoToProtoConverter {

    org.matveev.librarymanagementbookservice.proto.GetResponse convert(GetResponseDto dto);

    SearchResponse convert(SearchResponseDto dto);

    org.matveev.librarymanagementbookservice.proto.Book convert(org.matveev.librarymanagementbookservice.domain.entity.Book book);
}

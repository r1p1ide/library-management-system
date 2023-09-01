package org.matveev.bookservice.grpc.converter;

import org.matveev.bookservice.domain.dto.*;
import org.matveev.bookservice.proto.*;

public interface DtoToProtoConverter {

    GetResponse convert(GetResponseDto dto);

    SearchResponse convert(SearchResponseDto dto);

    Book convert(org.matveev.bookservice.domain.entity.Book book);
}

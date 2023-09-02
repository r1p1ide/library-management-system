package org.matveev.librarymanagementbookservice.service.converter;

import org.matveev.librarymanagementbookservice.domain.dto.*;
import org.matveev.librarymanagementbookservice.domain.entity.Book;

public interface BookConverter {

    Book convert(AddRequestDto dto);

    Book convert(UpdateRequestDto dto);

    GetResponseDto convert(Book book);
}

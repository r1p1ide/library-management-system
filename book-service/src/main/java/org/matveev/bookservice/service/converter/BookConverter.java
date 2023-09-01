package org.matveev.bookservice.service.converter;

import org.matveev.bookservice.domain.dto.*;
import org.matveev.bookservice.domain.entity.Book;

public interface BookConverter {

    Book convert(AddRequestDto dto);

    Book convert(UpdateRequestDto dto);

    GetResponseDto convert(Book book);
}

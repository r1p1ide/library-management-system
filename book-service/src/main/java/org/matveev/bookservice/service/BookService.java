package org.matveev.bookservice.service;

import org.matveev.bookservice.domain.dto.*;

public interface BookService {

    void save(AddRequestDto dto);

    void delete(DeleteRequestDto dto);

    void update(UpdateRequestDto dto);

    GetResponseDto get(GetRequestDto dto);

    SearchResponseDto search(SearchRequestDto dto);
}

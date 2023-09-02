package org.matveev.librarymanagementbookservice.service;

import org.matveev.librarymanagementbookservice.domain.dto.*;

public interface BookService {

    void save(AddRequestDto dto);

    void delete(DeleteRequestDto dto);

    void update(UpdateRequestDto dto);

    GetResponseDto get(GetRequestDto dto);

    SearchResponseDto search(SearchRequestDto dto);
}

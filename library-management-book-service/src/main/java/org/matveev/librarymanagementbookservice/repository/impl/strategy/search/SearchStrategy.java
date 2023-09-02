package org.matveev.librarymanagementbookservice.repository.impl.strategy.search;

import org.matveev.librarymanagementbookservice.domain.SearchType;
import org.matveev.librarymanagementbookservice.domain.dto.SearchRequestDto;
import org.matveev.librarymanagementbookservice.domain.dto.SearchResponseDto;

public interface SearchStrategy {

    boolean isApply(SearchType searchType);

    SearchResponseDto search(SearchRequestDto dto);
}

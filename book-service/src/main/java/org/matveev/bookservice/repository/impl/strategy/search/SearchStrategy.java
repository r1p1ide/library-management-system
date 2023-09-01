package org.matveev.bookservice.repository.impl.strategy.search;

import org.matveev.bookservice.domain.SearchType;
import org.matveev.bookservice.domain.dto.SearchRequestDto;
import org.matveev.bookservice.domain.dto.SearchResponseDto;

public interface SearchStrategy {

    boolean isApply(SearchType searchType);

    SearchResponseDto search(SearchRequestDto dto);
}

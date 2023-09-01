package org.matveev.bookservice.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.matveev.bookservice.domain.SearchType;

@Data
@Builder
public class SearchRequestDto {

    private String query;
    private SearchType searchType;

}

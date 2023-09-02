package org.matveev.librarymanagementbookservice.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.matveev.librarymanagementbookservice.domain.SearchType;

@Data
@Builder
public class SearchRequestDto {

    private String query;
    private SearchType searchType;

}

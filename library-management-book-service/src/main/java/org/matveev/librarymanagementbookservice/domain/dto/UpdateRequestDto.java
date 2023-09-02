package org.matveev.librarymanagementbookservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRequestDto {

    private String title;
    private String author;
    private String isbn;
    private Integer copies;

}

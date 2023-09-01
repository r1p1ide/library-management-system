package org.matveev.bookservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetResponseDto {

    private long id;
    private String title;
    private String author;
    private String isbn;
    private int copies;

}
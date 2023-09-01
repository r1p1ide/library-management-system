package org.matveev.bookservice.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.matveev.bookservice.domain.entity.Book;

import java.util.List;

@Data
@Builder
public class SearchResponseDto {

    private List<Book> books;

}

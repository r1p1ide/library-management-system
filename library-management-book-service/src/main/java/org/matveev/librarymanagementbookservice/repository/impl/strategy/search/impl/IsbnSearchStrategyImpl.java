package org.matveev.librarymanagementbookservice.repository.impl.strategy.search.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.librarymanagementbookservice.domain.SearchType;
import org.matveev.librarymanagementbookservice.domain.dto.SearchRequestDto;
import org.matveev.librarymanagementbookservice.domain.dto.SearchResponseDto;
import org.matveev.librarymanagementbookservice.domain.entity.Book;
import org.matveev.librarymanagementbookservice.repository.impl.strategy.search.SearchStrategy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IsbnSearchStrategyImpl implements SearchStrategy {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean isApply(SearchType searchType) {
        return SearchType.ISBN == searchType;
    }

    @Override
    public SearchResponseDto search(SearchRequestDto dto) {
        List<Book> books = namedParameterJdbcTemplate.query(
                "SELECT * FROM books b WHERE b.isbn=:isbn",
                new MapSqlParameterSource("isbn", dto.getQuery()),
                BeanPropertyRowMapper.newInstance(Book.class)
        );
        return SearchResponseDto.builder()
                .books(books)
                .build();
    }

}

package org.matveev.bookservice.repository.impl.strategy.search.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.bookservice.domain.SearchType;
import org.matveev.bookservice.domain.dto.SearchRequestDto;
import org.matveev.bookservice.domain.dto.SearchResponseDto;
import org.matveev.bookservice.domain.entity.Book;
import org.matveev.bookservice.repository.impl.strategy.search.SearchStrategy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TitleSearchStrategyImpl implements SearchStrategy {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean isApply(SearchType searchType) {
        return SearchType.TITLE == searchType;
    }

    @Override
    public SearchResponseDto search(SearchRequestDto dto) {
        List<Book> books = namedParameterJdbcTemplate.query(
                "SELECT * FROM books b WHERE b.title=:title",
                new MapSqlParameterSource("title", dto.getQuery().toUpperCase() + "%"),
                BeanPropertyRowMapper.newInstance(Book.class)
        );
        return SearchResponseDto.builder()
                .books(books)
                .build();
    }

}

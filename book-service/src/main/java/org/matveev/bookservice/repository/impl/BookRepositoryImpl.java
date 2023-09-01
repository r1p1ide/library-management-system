package org.matveev.bookservice.repository.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.bookservice.domain.SearchType;
import org.matveev.bookservice.domain.dto.SearchRequestDto;
import org.matveev.bookservice.domain.dto.SearchResponseDto;
import org.matveev.bookservice.domain.entity.Book;
import org.matveev.bookservice.exception.SearchTypeNotFoundException;
import org.matveev.bookservice.repository.BookRepository;
import org.matveev.bookservice.repository.impl.strategy.search.SearchStrategy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final List<SearchStrategy> searchStrategies;

    @Override
    public void add(Book book) {
        namedParameterJdbcTemplate.update(
                "INSERT INTO books (id, title, author, isbn, copies) " +
                        "VALUES (DEFAULT, :title, :author, :isbn, :copies)",
                new MapSqlParameterSource()
                        .addValue("title", book.getTitle())
                        .addValue("author", book.getAuthor())
                        .addValue("isbn", book.getIsbn())
                        .addValue("copies", book.getCopies())
        );
    }

    @Override
    public void delete(long id) {
        namedParameterJdbcTemplate.update(
                "DELETE FROM books WHERE id=:id",
                new MapSqlParameterSource().addValue("id", id)
        );
    }

    @Override
    public void update(Book book) {
        namedParameterJdbcTemplate.update(
                "UPDATE books SET title=:title, author=:author, copies=:copies WHERE isbn=:isbn",
                new MapSqlParameterSource()
                        .addValue("title", book.getTitle())
                        .addValue("author", book.getAuthor())
                        .addValue("isbn", book.getIsbn())
                        .addValue("copies", book.getCopies())
        );
    }

    @Override
    public Book get(long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "SELECT * FROM books WHERE id=:id",
                new MapSqlParameterSource().addValue("id", id),
                BeanPropertyRowMapper.newInstance(Book.class)
        );
    }

    @Override
    public SearchResponseDto search(SearchRequestDto dto) {
        return searchStrategies.stream()
                .filter(strategy -> strategy.isApply(dto.getSearchType()))
                .findFirst()
                .orElseThrow(() -> new SearchTypeNotFoundException("Unknown searchType=" + dto.getSearchType()))
                .search(dto);
    }

}

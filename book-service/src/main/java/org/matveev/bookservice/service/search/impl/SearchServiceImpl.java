package org.matveev.bookservice.service.search.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.matveev.bookservice.domain.SearchType;
import org.matveev.bookservice.domain.dto.SearchRequestDto;
import org.matveev.bookservice.domain.entity.Book;
import org.matveev.bookservice.repository.BookRepository;
import org.matveev.bookservice.service.search.SearchService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final BookRepository bookRepository;

    @Override
    public Book search(String isbn) {
        var searchRequest = SearchRequestDto.builder()
                .query(isbn)
                .searchType(SearchType.ISBN)
                .build();

        log.info("Checking for existence in the database. Input: isbn={}", isbn);
        var searchResponse = bookRepository.search(searchRequest);

        var check = !searchResponse.getBooks().isEmpty();
        log.info(
                check ?
                        "A book with such an ISBN exists. The number of copies will be increased"
                        :
                        "A book with such an ISBN doesn't exists. The book will be added to the storage"
        );

        return check ? searchResponse.getBooks().get(0) : null;
    }

}

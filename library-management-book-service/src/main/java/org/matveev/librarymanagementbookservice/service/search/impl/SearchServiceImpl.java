package org.matveev.librarymanagementbookservice.service.search.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.matveev.librarymanagementbookservice.domain.SearchType;
import org.matveev.librarymanagementbookservice.domain.dto.SearchRequestDto;
import org.matveev.librarymanagementbookservice.domain.entity.Book;
import org.matveev.librarymanagementbookservice.repository.BookRepository;
import org.matveev.librarymanagementbookservice.service.search.SearchService;
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

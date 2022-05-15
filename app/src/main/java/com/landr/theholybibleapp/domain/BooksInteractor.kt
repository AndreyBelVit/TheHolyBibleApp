package com.landr.theholybibleapp.domain

import com.landr.theholybibleapp.data.BooksDataToDomainMapper
import com.landr.theholybibleapp.data.BooksRepository

interface BooksInteractor {

   suspend fun fetchBooks(): BookDomain

    class Base(
        private val booksRepository: BooksRepository,
        private val mapper: BooksDataToDomainMapper
    ) : BooksInteractor {
        override suspend fun fetchBooks(): BookDomain {
            return booksRepository.fetchBooks().map(mapper)
        }
    }
}
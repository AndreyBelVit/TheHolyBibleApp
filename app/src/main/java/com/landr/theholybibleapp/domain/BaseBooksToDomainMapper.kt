package com.landr.theholybibleapp.domain

import com.landr.theholybibleapp.core.Book
import com.landr.theholybibleapp.data.BooksDataToDomainMapper

class BaseBooksToDomainMapper : BooksDataToDomainMapper {
    override fun map(books: List<Book>): BookDomain {
        return BookDomain.Success(books)
    }

    override fun map(exception: Exception): BookDomain {
        return BookDomain.Fail(exception)
    }
}
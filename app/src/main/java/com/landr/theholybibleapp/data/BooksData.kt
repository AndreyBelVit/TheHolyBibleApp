package com.landr.theholybibleapp.data

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book
import com.landr.theholybibleapp.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(books)
        }

    }

    class Fail(private val exception: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(exception)
        }

    }

}
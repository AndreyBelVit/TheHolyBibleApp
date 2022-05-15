package com.landr.theholybibleapp.data

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book
import com.landr.theholybibleapp.domain.BookDomain

interface BooksDataToDomainMapper: Abstract.Mapper {

    fun map(books: List<Book>): BookDomain

    fun map(exception: Exception): BookDomain

}
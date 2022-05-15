package com.landr.theholybibleapp.domain

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book
import com.landr.theholybibleapp.presentation.BooksUi

interface BooksDomainToUiMapper : Abstract.Mapper {

    fun map(books: List<Book>): BooksUi

    fun map(errorType: ErrorType): BooksUi
}
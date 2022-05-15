package com.landr.theholybibleapp.domain

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book
import com.landr.theholybibleapp.presentation.BooksUi
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

sealed class BookDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper>() {

    class Success(private val books: List<Book>) : BookDomain() {
        override fun map(mapper: BooksDomainToUiMapper): BooksUi {
            return mapper.map(books)
        }
    }

    class Fail(private val exception: Exception) : BookDomain() {
        override fun map(mapper: BooksDomainToUiMapper): BooksUi = mapper.map(
            when (exception) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}
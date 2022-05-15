package com.landr.theholybibleapp.data

import com.landr.theholybibleapp.data.net.BookCloud
import com.landr.theholybibleapp.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val service: BooksService) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> {
            return service.fetchBooks()
        }
    }

}
package com.landr.theholybibleapp.data

import com.landr.theholybibleapp.data.cache.BooksCacheDataSource
import com.landr.theholybibleapp.data.cache.BooksCacheMapper
import java.lang.Exception

interface BooksRepository {

    suspend fun fetchBooks(): BooksData

    class Base(
        private val booksCloudDataSource: BooksCloudDataSource,
        private val cacheDataSource: BooksCacheDataSource,
        private val booksCacheMapper: BooksCacheMapper,
        private val booksCloudMapper: BooksCloudMapper
    ) : BooksRepository {
        override suspend fun fetchBooks(): BooksData = try {
            val booksCacheList = cacheDataSource.fetch()
            if (booksCacheList.isEmpty()) {
                val booksCloudList = booksCloudDataSource.fetchBooks()
                val books = booksCloudMapper.map(booksCloudList)
                cacheDataSource.saveBooks(books)
                BooksData.Success(books)
            } else {
                BooksData.Success(booksCacheMapper.map(booksCacheList))
            }
        } catch (e: Exception) {
            BooksData.Fail(e)
        }

    }
}


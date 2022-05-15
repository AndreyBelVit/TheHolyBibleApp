package com.landr.theholybibleapp.data.cache

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>): List<Book>

    class Base(private val mapper: BookCacheMapper) : BooksCacheMapper {
        override fun map(books: List<BookDb>): List<Book> {
            return books.map {
                it.map(mapper)
            }
        }
    }
}
package com.landr.theholybibleapp.data

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book
import com.landr.theholybibleapp.data.net.BookCloud
import com.landr.theholybibleapp.data.net.BookCloudMapper

interface BooksCloudMapper: Abstract.Mapper {
    fun map(cloudList: List<BookCloud>): List<Book>

    class Base(private val bookMapper: BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>): List<Book> {
            return cloudList.map {
                it.map(bookMapper)
            }
        }
    }
}
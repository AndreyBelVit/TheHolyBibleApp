package com.landr.theholybibleapp.data.cache

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book

interface BookCacheMapper : Abstract.Mapper {
    fun map(bookDb: BookDb): Book

    class Base : BookCacheMapper {
        override fun map(bookDb: BookDb): Book {
            return Book(bookDb.id, bookDb.name)
        }
    }
}
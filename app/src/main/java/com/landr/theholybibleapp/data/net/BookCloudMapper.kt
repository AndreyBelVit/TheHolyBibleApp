package com.landr.theholybibleapp.data.net

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book

interface BookCloudMapper : Abstract.Mapper {

    fun map(id: Int, name: String): Book

    class Base: BookCloudMapper {
        override fun map(id: Int, name: String): Book {
            return Book(id, name)
        }
    }

}
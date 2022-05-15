package com.landr.theholybibleapp.data.cache

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb: RealmObject(),Abstract.Mapable<Book, BookCacheMapper> {

    @PrimaryKey
    var id: Int = -1
    var name: String = ""

    override fun map(mapper: BookCacheMapper): Book {
        return Book(id, name)
    }

}
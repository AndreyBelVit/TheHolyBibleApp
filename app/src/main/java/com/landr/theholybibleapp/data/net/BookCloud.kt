package com.landr.theholybibleapp.data.net

import com.google.gson.annotations.SerializedName
import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.core.Book

data class BookCloud(

    @SerializedName("id")
    private val id: Int,

    @SerializedName("name")
    private val name: String

) : Abstract.Object<Book, BookCloudMapper>() {

    override fun map(mapper: BookCloudMapper): Book {
        return mapper.map(id, name)
    }
}
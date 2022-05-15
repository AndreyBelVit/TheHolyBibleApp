package com.landr.theholybibleapp.data.cache

import com.landr.theholybibleapp.core.Book

interface BooksCacheDataSource {

    fun fetch(): List<BookDb>

    fun saveBooks(books: List<Book>)

    class Base(private val provider: RealmProvider) : BooksCacheDataSource {
        override fun fetch(): List<BookDb> {
            provider.provide().use {
                return it.copyFromRealm(it.where(BookDb::class.java).findAll() ?: emptyList())
            }
        }

        override fun saveBooks(books: List<Book>) {
            provider.provide().use {
                it.executeTransaction {
                    books.forEach { book ->
                        val bookDb = it.createObject(BookDb::class.java, book.id)
                        bookDb.name = book.name
                    }

                }
            }
        }
    }
}
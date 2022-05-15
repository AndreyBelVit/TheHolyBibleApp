package com.landr.theholybibleapp.core

import android.app.Application
import com.landr.theholybibleapp.data.BooksRepository
import com.landr.theholybibleapp.domain.BaseBooksToDomainMapper
import com.landr.theholybibleapp.domain.BooksInteractor

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val booksRepository: BooksRepository = TODO("merge")

        val booksInteractor = BooksInteractor.Base(booksRepository, BaseBooksToDomainMapper())
    }
}
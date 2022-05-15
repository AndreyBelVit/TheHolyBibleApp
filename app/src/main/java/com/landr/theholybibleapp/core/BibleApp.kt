package com.landr.theholybibleapp.core

import android.app.Application
import com.landr.theholybibleapp.data.BooksCloudDataSource
import com.landr.theholybibleapp.data.BooksCloudMapper
import com.landr.theholybibleapp.data.BooksRepository
import com.landr.theholybibleapp.data.cache.BookCacheMapper
import com.landr.theholybibleapp.data.cache.BooksCacheDataSource
import com.landr.theholybibleapp.data.cache.BooksCacheMapper
import com.landr.theholybibleapp.data.cache.RealmProvider
import com.landr.theholybibleapp.data.net.BookCloudMapper
import com.landr.theholybibleapp.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        val service = retrofit.create(BooksService::class.java)
        val booksCloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksRepository = BooksRepository.Base(
            booksCloudDataSource,
            cacheDataSource,
            booksCacheMapper,
            booksCloudMapper
        )
    }

}
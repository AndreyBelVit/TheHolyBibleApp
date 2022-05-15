package com.landr.theholybibleapp.data

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){

}
package com.landr.theholybibleapp.domain

import com.landr.theholybibleapp.core.Abstract
import com.landr.theholybibleapp.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, Abstract.Mapper.Empty>(){

    class Success(): BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }
    }

    class Fail(): BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }
    }

}
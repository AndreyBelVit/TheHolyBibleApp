package com.landr.theholybibleapp.core

abstract class Abstract {

    abstract class Object<T, M : Mapper> {

        abstract fun map(mapper: M): T

    }

    //FIXME
    interface Mapable<T, M : Mapper> {
        fun map(mapper: M): T
    }

    interface Mapper {
        class Empty : Mapper
    }

}
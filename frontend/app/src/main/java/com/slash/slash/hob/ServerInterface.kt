package com.slash.slash.hob

import io.reactivex.Flowable
import retrofit2.http.GET

interface ServerInterface {
    @GET("/")
    fun getText() : Flowable<String>
}
package com.slash.slash.hob

import com.google.gson.GsonBuilder
import com.slash.slash.hob.models.User
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServerHandler {
    const val url = "http://172.20.10.6:3000"
    private val client = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()

    private val gsonBuilder = GsonBuilder()
            .setLenient()
            .create()

    private val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private val serverInterface = retrofit.create(ServerInterface::class.java)

    fun getInterface(): ServerInterface = serverInterface

    fun signUp(user: User): Flowable<String> {
        return serverInterface.signUp(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAllHobList(skip: Int): Flowable<String> {
        return serverInterface.getAllHobList(skip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getClassList(userIdx: String, skip: Int): Flowable<String> {
        return serverInterface.getClassList(userIdx, skip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getPickList(userIdx: String, skip: Int): Flowable<String> {
        return serverInterface.getPickList(userIdx, skip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getFinList(userIdx: String, skip: Int): Flowable<String> {
        return serverInterface.getFinList(userIdx, skip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun classRegister(userIdx: String, classIdx: String, title: String): Flowable<String> {
        return serverInterface.classRegister(userIdx, classIdx, title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun classPickup(userIdx: String, classIdx: String, title: String): Flowable<String> {
        return serverInterface.classPickup(userIdx, classIdx, title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun classFin(userIdx: String, classIdx: String, title: String): Flowable<String> {
        return serverInterface.classFin(userIdx, classIdx, title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun classGetDetail(classIdx: String): Flowable<String> {
        return serverInterface.classGetDetail(classIdx)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun classSearch(title: String): Flowable<String> {
        return serverInterface.classSearch(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
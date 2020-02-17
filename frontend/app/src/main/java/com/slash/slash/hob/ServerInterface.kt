package com.slash.slash.hob

import com.slash.slash.hob.models.User
import io.reactivex.Flowable
import retrofit2.http.*

interface ServerInterface {
    @POST("/users/signup") // 회원가입
    fun signUp(@Body user: User): Flowable<String>

    @FormUrlEncoded
    @POST("/hob/all") // 서버에 있는 전체 클래스 목록
    fun getAllHobList(@Field("skip") skip: Int): Flowable<String>

    @FormUrlEncoded
    @POST("/hob/classlist") // 현재 수강중인 클래스 목록
    fun getClassList(@Field("idx") idx: String, @Field("skip") skip: Int): Flowable<String>

    @FormUrlEncoded
    @POST("/hob/picklist") // 찜한 클래스 목록
    fun getPickList(@Field("idx") idx: String, @Field("skip") skip: Int): Flowable<String>

    @FormUrlEncoded
    @POST("/hob/finlist") // 수강완료한 클래스 목록
    fun getFinList(@Field("idx") idx: String, @Field("skip") skip: Int): Flowable<String>


    @FormUrlEncoded
    @POST("/class/register") // 클래스 수강신청
    fun classRegister(@Field("idx") idx: String, @Field("classIdx") classIdx: String, @Field("title") title: String): Flowable<String>

    @FormUrlEncoded
    @POST("/class/pickup") // 클래스 찜하기
    fun classPickup(@Field("idx") idx: String, @Field("classIdx") classIdx: String, @Field("title") title: String): Flowable<String>

    @FormUrlEncoded
    @POST("/class/fin") // 클래스 수강 완료
    fun classFin(@Field("idx") idx: String, @Field("classIdx") classIdx: String, @Field("title") title: String): Flowable<String>

    @FormUrlEncoded
    @POST("/class/getdetail") // 클래스 세부내용 조회
    fun classGetDetail(@Field("classIdx") classIdx: String): Flowable<String>

    @FormUrlEncoded
    @POST("/class/search") // 클래스 검색
    fun classSearch(@Field("title") title: String): Flowable<String>
}
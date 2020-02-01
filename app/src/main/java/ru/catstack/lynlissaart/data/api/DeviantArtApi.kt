package ru.catstack.lynlissaart.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.catstack.lynlissaart.domain.DeviantResponse

interface DeviantArtApi {

    @GET("rss.xml")
    fun getQueryResult(@Query(value = "q") query: String): Call<DeviantResponse>

    fun getUserGallery(userName: String): Call<DeviantResponse>
}
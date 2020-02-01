package ru.catstack.lynlissaart.data.api

import retrofit2.Call
import ru.catstack.lynlissaart.domain.DeviantResponse

class DeviantArtApiWrapper(private val deviantArtApi: DeviantArtApi) : DeviantArtApi {

    override fun getQueryResult(query: String): Call<DeviantResponse> {
        return deviantArtApi.getQueryResult(query)
    }

    override fun getUserGallery(userName: String): Call<DeviantResponse> {
        return deviantArtApi.getQueryResult("gallery:${userName}")
    }
}
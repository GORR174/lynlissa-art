package ru.catstack.lynlissaart.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.catstack.lynlissaart.data.api.DeviantArtApi
import ru.catstack.lynlissaart.domain.Art
import java.lang.Exception

class UserGalleryNetworkRepo(private val api: DeviantArtApi) : UserGalleryRepo {
    override fun getUserGallery(userName: String, callback: (ArrayList<Art>, isSuccessful: Boolean) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getUserGallery(userName).execute().body()
                callback.invoke(response?.arts ?: ArrayList(), true)
            } catch (exception: Exception) {
                callback.invoke(ArrayList(), false)
            }
        }
    }
}
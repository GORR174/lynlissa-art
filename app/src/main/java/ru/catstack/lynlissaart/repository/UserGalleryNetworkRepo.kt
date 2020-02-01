package ru.catstack.lynlissaart.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.catstack.lynlissaart.data.api.DeviantArtApi
import ru.catstack.lynlissaart.domain.Art

class UserGalleryNetworkRepo(private val api: DeviantArtApi) : UserGalleryRepo {
    override fun getUserGallery(userName: String, callback: (ArrayList<Art>) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getUserGallery(userName).execute().body()
            callback.invoke(response?.arts ?: ArrayList())
        }
    }
}
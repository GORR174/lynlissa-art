package ru.catstack.lynlissaart.repository

import ru.catstack.lynlissaart.domain.Art

interface UserGalleryRepo {
    fun getUserGallery(userName: String, callback: (ArrayList<Art>, Boolean) -> Unit)
}
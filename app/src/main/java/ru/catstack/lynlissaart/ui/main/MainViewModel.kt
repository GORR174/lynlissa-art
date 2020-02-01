package ru.catstack.lynlissaart.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.catstack.lynlissaart.domain.Art
import ru.catstack.lynlissaart.repository.UserGalleryRepo

class MainViewModel(private val repository: UserGalleryRepo) : ViewModel() {
    private val userName = "lynlissa"

    private val mutableArts = MutableLiveData<ArrayList<Art>>(ArrayList())
    val arts: LiveData<ArrayList<Art>>
    get() = mutableArts

    fun loadImages() {
        repository.getUserGallery(userName) {
            mutableArts.postValue(it)
        }
    }
}

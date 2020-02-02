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

    private val mutableState = MutableLiveData<MainState>(MainState.LOADING)
    val state: LiveData<MainState>
        get() = mutableState

    fun loadImages() {
        mutableState.postValue(MainState.LOADING)
        repository.getUserGallery(userName) { arts, isSuccessful ->
            if (isSuccessful) {
                mutableArts.postValue(arts)
                mutableState.postValue(MainState.LOADED)
            } else {
                mutableState.postValue(MainState.ERROR)
            }
        }
    }

    enum class MainState {
        LOADING,
        ERROR,
        LOADED,
    }
}

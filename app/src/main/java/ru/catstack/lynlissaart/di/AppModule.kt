package ru.catstack.lynlissaart.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.catstack.lynlissaart.ui.item.ImageItemViewModel
import ru.catstack.lynlissaart.repository.UserGalleryNetworkRepo
import ru.catstack.lynlissaart.repository.UserGalleryRepo
import ru.catstack.lynlissaart.ui.main.MainViewModel

val appModule = Kodein.Module("app") {
    bind<MainViewModel>() with provider { MainViewModel(instance()) }
    bind<ImageItemViewModel>() with provider { ImageItemViewModel() }
    bind<UserGalleryRepo>() with singleton { UserGalleryNetworkRepo(instance()) }
}
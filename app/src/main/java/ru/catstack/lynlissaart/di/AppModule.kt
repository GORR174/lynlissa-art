package ru.catstack.lynlissaart.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import ru.catstack.lynlissaart.ui.main.MainViewModel

val appModule = Kodein.Module("app") {
    bind<MainViewModel>() with provider { MainViewModel() }
}
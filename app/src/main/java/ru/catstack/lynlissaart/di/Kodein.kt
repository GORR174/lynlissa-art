package ru.catstack.lynlissaart.di

import org.kodein.di.Kodein
import org.kodein.di.generic.instance

object KodeinInstance {
    val kodein = Kodein {
        import(appModule)
        import(networkModule)
    }

    inline fun <reified T : Any> instance() = kodein.instance<T>()
}
package ru.catstack.lynlissaart.di

import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import ru.catstack.lynlissaart.data.api.DeviantArtApi
import ru.catstack.lynlissaart.data.api.DeviantArtApiWrapper
import ru.catstack.lynlissaart.data.api.deviantart.DeviantResponseConverterFactory

val networkModule = Kodein.Module("network") {

    bind<DeviantArtApi>() with singleton {
        val baseApi = Retrofit.Builder()
            .baseUrl("https://backend.deviantart.com/")
            .client(instance())
            .addConverterFactory(
                DeviantResponseConverterFactory()
            )
            .build()
            .create(DeviantArtApi::class.java)

        return@singleton DeviantArtApiWrapper(baseApi)
    }

    bind<OkHttpClient>() with singleton {
        OkHttpClient.Builder()
            .build()
    }
}
package ru.catstack.lynlissaart

import org.junit.Test

import org.junit.Assert.*
import ru.catstack.lynlissaart.data.api.DeviantArtApi
import ru.catstack.lynlissaart.di.KodeinInstance

class ApiUnitTest {
    @Test
    fun getUserGallery_isCorrect() {
        val api: DeviantArtApi by KodeinInstance.instance()
        val deviantResponse = api.getUserGallery("lynlissa").execute().body()

        assertEquals("The book of the dragon master", deviantResponse?.arts?.last()?.title)
    }
}

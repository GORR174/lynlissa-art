package ru.catstack.lynlissaart.domain

import java.io.Serializable

data class Art(val title: String, val imageUrl: String, val description: String) : Serializable

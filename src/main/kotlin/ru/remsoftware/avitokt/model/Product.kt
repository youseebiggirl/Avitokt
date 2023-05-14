package ru.remsoftware.avitokt.model



data class Product(
    val id: Long = 0,
    val title: String,
    val description: String,
    val price: Int,
    val city: String,
)

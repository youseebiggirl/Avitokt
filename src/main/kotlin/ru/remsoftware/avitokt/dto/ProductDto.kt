package ru.remsoftware.avitokt.dto

data class ProductDto(
    val id: Long = 0,
    val title: String,
    val description: String,
    val price: Int,
    val city: String,
)

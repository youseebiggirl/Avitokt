package ru.remsoftware.avitokt.exeption

data class ApiError(
    val errorCode: String,
    val message: String,
)
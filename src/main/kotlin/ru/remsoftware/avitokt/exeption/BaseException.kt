package ru.remsoftware.avitokt.exeption

import org.springframework.http.HttpStatus

abstract class BaseException(
    val errorCode: String,
    override val message: String,
    val status: HttpStatus
) :
    RuntimeException(message)

class ProductNotFoundException(id: Long) : BaseException(
    errorCode = "product.not.found",
    message = "Product with id = $id not found",
    status = HttpStatus.NOT_FOUND,
)
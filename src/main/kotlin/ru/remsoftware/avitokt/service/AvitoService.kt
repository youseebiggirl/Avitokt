package ru.remsoftware.avitokt.service

import ru.remsoftware.avitokt.dto.ProductDto

interface AvitoService {

    fun getAll(): List<ProductDto>

    fun getById(id: Long): ProductDto

    fun create(dto: ProductDto): Int

    fun update(id: Long, dto: ProductDto)

    fun deleteById(id: Long)
}
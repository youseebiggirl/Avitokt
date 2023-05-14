package ru.remsoftware.avitokt.service

import org.springframework.stereotype.Service
import ru.remsoftware.avitokt.dto.ProductDto
import ru.remsoftware.avitokt.exeption.ProductNotFoundException
import ru.remsoftware.avitokt.model.Product
import ru.remsoftware.avitokt.repository.AvitoRepository

@Service
class AvitoServiceImpl(
    private val avitoRepository: AvitoRepository,
) : AvitoService {

    override fun getAll(): List<ProductDto> = avitoRepository.getAll().map { it.toDto() }

    override fun getById(id: Long): ProductDto =
        avitoRepository.findById(id)
            ?.toDto()
            ?: throw ProductNotFoundException(id)

    override fun create(dto: ProductDto): Int =
        avitoRepository.create(dto.title, dto.description, dto.price, dto.city)


    override fun update(id: Long, dto: ProductDto) =
        avitoRepository.update(dto.id, dto.title, dto.description, dto.price, dto.city)

    override fun deleteById(id: Long) =
        avitoRepository.deleteById(id)

    private fun Product.toDto() = ProductDto(
        id = id,
        title = title,
        description = description,
        price = price,
        city = city,
    )
}
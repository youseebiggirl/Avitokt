package ru.remsoftware.avitokt.controller

import org.springframework.web.bind.annotation.*
import ru.remsoftware.avitokt.dto.ProductDto
import ru.remsoftware.avitokt.service.AvitoService

@RestController
@RequestMapping("/avito")
class AvitoController(
    private val avitoService: AvitoService,
) {

    @GetMapping
    fun getAll(): List<ProductDto> = avitoService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ProductDto = avitoService.getById(id)

    @PostMapping
    fun create(@RequestBody dto: ProductDto): Int =
        avitoService.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: ProductDto) {
        avitoService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        avitoService.deleteById(id)
    }
}
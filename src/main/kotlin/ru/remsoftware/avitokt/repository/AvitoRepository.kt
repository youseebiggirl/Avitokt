package ru.remsoftware.avitokt.repository


import ru.remsoftware.avitokt.model.Product

interface AvitoRepository {

    fun getAll(): List<Product>

    fun findById(id: Long): Product?

    fun create(title: String, description: String, price: Int, city: String): Int

    fun update(id: Long, title: String, description: String, price: Int, city: String)

    fun deleteById(id: Long)
}
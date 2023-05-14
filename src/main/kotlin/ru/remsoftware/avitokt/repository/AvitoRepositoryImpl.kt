package ru.remsoftware.avitokt.repository

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import ru.remsoftware.avitokt.model.Product

@Repository
class AvitoRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
) : AvitoRepository {
    override fun getAll(): List<Product> =
        jdbcTemplate.query(
            "select * from products order by id",
            ROW_MAPPER
        )

    override fun findById(id: Long): Product? =
        jdbcTemplate.query(
            "select * from products where id = :id",
            mapOf(
                "id" to id,
            ),
            ROW_MAPPER
        ).firstOrNull()

    override fun create(title: String, description: String, price: Int, city: String): Int {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            "insert into products(title, description, price, city) values(:title, :description, :price, :city)",
            MapSqlParameterSource(
                mapOf(
                    "title" to title,
                    "description" to description,
                    "price" to price,
                    "city" to city,
                )
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )
        return keyHolder.keys?.getValue("id") as Int
    }

    override fun update(id: Long, title: String, description: String, price: Int, city: String) {
        jdbcTemplate.update(
            "update products set title = :title, description = :description, price = :price, city = :city,  int not null  where id = :id",
            mapOf(
                "id" to id,
                "title" to title,
                "description" to description,
                "price" to price,
                "city" to city,
            )
        )
    }

    override fun deleteById(id: Long) {
        jdbcTemplate.update(
            "delete from products where id = :id",
            mapOf(
                "id" to id
            )
        )
    }

    private companion object {
        val ROW_MAPPER = RowMapper<Product> { rs, _ ->
            Product(
                id = rs.getLong("id"),
                title = rs.getString("title"),
                description = rs.getString("description"),
                price = rs.getInt("price"),
                city = rs.getString("city"),
            )
        }
    }
}
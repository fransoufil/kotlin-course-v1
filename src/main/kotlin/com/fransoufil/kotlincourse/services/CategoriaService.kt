package com.fransoufil.kotlincourse.services

import com.fransoufil.kotlincourse.entities.Categoria
import com.fransoufil.kotlincourse.repositories.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoriaService {

    @Autowired
    private lateinit var categoriaRepository: CategoriaRepository

    fun findAll(): List<Categoria> {
        val list: List<Categoria> = categoriaRepository.findAll()
        return list
    }

    fun findById(id: Int): Categoria? {
        val obj = categoriaRepository.findById(id)
        return obj.orElse(null)
    }

    fun insert(obj: Categoria): Categoria {
        obj.id = null
        return categoriaRepository.save(obj)
    }
}
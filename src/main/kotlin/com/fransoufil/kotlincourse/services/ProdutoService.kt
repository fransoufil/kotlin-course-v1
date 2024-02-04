package com.fransoufil.kotlincourse.services

import com.fransoufil.kotlincourse.entities.Produto
import com.fransoufil.kotlincourse.repositories.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService {

    @Autowired
    private lateinit var produtoRepository: ProdutoRepository

    fun findAll(): List<Produto> {
        val list: List<Produto> = produtoRepository.findAll()
        return list
    }

    fun findById(id: Int): Produto{
        val obj = produtoRepository.findById(id)
        return obj.orElse(null)
    }
}
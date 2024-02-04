package com.fransoufil.kotlincourse.controllers

import com.fransoufil.kotlincourse.entities.Produto
import com.fransoufil.kotlincourse.services.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produtos")
class ProdutoController {

    @Autowired
    private lateinit var produtoService: ProdutoService

    @GetMapping
    fun findAll(): List<Produto>{
        val list: List<Produto> = produtoService.findAll()
        return list
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): ResponseEntity<Any> {
        val obj = produtoService.findById(id)
        return ResponseEntity.ok().body(obj)
    }
}
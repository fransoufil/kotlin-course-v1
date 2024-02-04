package com.fransoufil.kotlincourse.controllers

import com.fransoufil.kotlincourse.entities.Categoria
import com.fransoufil.kotlincourse.services.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categorias")
class CategoriaController {

    @Autowired
    private lateinit var categoriaService: CategoriaService

    @GetMapping
    fun findAll(): ResponseEntity<List<Categoria>> {
        val list: List<Categoria> = categoriaService.findAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): ResponseEntity<Any> {
        val obj = categoriaService.findById(id)
        return ResponseEntity.ok().body(obj)
    }
}
package com.fransoufil.kotlincourse.controllers

import com.fransoufil.kotlincourse.entities.Categoria
import com.fransoufil.kotlincourse.services.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

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
    fun findById(@PathVariable id: Int): ResponseEntity<Any> {
        val obj = categoriaService.findById(id)
        return ResponseEntity.ok().body(obj)
    }

    @PostMapping
    fun insert(@RequestBody obj: Categoria): ResponseEntity<Void> {
        val obj = categoriaService.insert(obj)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.id).toUri()
        return ResponseEntity.created(uri).build()
    }
}
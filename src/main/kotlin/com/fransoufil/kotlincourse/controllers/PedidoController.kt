package com.fransoufil.kotlincourse.controllers

import com.fransoufil.kotlincourse.services.PedidoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pedidos")
class PedidoController {

    @Autowired
    private lateinit var pedidoService: PedidoService

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Any> {
        val obj = pedidoService.findById(id)
        return ResponseEntity.ok().body(obj)
    }
}
package com.fransoufil.kotlincourse.controllers

import com.fransoufil.kotlincourse.entities.Cliente
import com.fransoufil.kotlincourse.services.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class ClienteController {

    @Autowired
    private lateinit var clienteService: ClienteService

    @GetMapping
    fun findAll(): ResponseEntity<List<Cliente>> {
        val list: List<Cliente> = clienteService.findAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Any> {
        val obj = clienteService.findById(id)
        return ResponseEntity.ok().body(obj)
    }
}
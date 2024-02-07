package com.fransoufil.kotlincourse.services

import com.fransoufil.kotlincourse.entities.Cliente
import com.fransoufil.kotlincourse.repositories.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClienteService {

    @Autowired
    private lateinit var clienteRepository: ClienteRepository

    fun findAll(): List<Cliente> {
        val list: List<Cliente> = clienteRepository.findAll()
        return list
    }

    fun findById(id: Int): Cliente {
        val obj = clienteRepository.findById(id)
        return obj.orElse(null)
    }
}
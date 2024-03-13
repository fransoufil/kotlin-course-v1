package com.fransoufil.kotlincourse.services

import com.fransoufil.kotlincourse.entities.Pedido
import com.fransoufil.kotlincourse.repositories.PedidoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PedidoService {

    @Autowired
    private lateinit var pedidoRepository: PedidoRepository

    fun findById(id: Int): Pedido {
        val obj = pedidoRepository.findById(id)
        return  obj.orElse(null)
    }
}
package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository: JpaRepository<Pedido, Int> {
}
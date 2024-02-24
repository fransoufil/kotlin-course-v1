package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.ItemPedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemPedidoRepository: JpaRepository<ItemPedido, Int> {
}
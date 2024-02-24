package com.fransoufil.kotlincourse.entities

import jakarta.persistence.Embeddable
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.io.Serializable

@Embeddable
open class ItemPedidoPK : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @ManyToOne
    @JoinColumn(name="pedido_id")
    var pedido: Pedido? = null

    @ManyToOne
    @JoinColumn(name="produto_id")
    var produto: Produto? = null

    override fun hashCode(): Int = pedido.hashCode() * 31 + produto.hashCode()

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null || javaClass != other.javaClass -> false
        else -> pedido == (other as ItemPedidoPK).pedido && produto == other.produto
    }
}
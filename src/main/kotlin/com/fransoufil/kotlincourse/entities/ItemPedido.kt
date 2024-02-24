package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import java.io.Serializable
import java.text.NumberFormat
import java.util.*

@Entity
class ItemPedido : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @EmbeddedId
    var id: ItemPedidoPK = ItemPedidoPK()

    var desconto: Double? = null
    var quantidade: Int? = null
    var preco: Double? = null

    constructor(pedido: Pedido, produto: Produto, desconto: Double, quantidade: Int, preco: Double) {
        id.pedido = pedido
        id.produto = produto
        this.desconto = desconto
        this.quantidade = quantidade
        this.preco = preco
    }

    val subTotal: Double
        get() = (preco!! - desconto!!) * quantidade!!

    val pedido: Pedido?
        @JsonIgnore
        get() = id.pedido

    fun setPedido(pedido: Pedido) {
        id.pedido = pedido
    }

    val produto: Produto?
        get() = id.produto

    fun setProduto(produto: Produto) {
        id.produto = produto
    }

    override fun hashCode(): Int = id.hashCode()

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null || javaClass != other.javaClass -> false
        else -> id == (other as ItemPedido).id
    }

    override fun toString(): String {
        val nf = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return buildString {
            append(produto?.nome)
            append(", Qte: ")
            append(quantidade)
            append(", Preço unitário: ")
            append(nf.format(preco))
            append(", Subtotal: ")
            append(nf.format(subTotal))
            append("\n")
        }
    }
}
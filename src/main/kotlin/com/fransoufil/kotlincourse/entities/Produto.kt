package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
class Produto : Serializable {
    companion object{
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var nome: String? = null
    var preco: Double? = null

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "PRODUTO_CATEGORIA",
        joinColumns = [JoinColumn(name = "produto_id")],
        inverseJoinColumns = [JoinColumn(name = "categoria_id")]
    )
    var categorias: MutableList<Categoria> = mutableListOf()


    @OneToMany(mappedBy = "id.produto")
    var itens: MutableSet<ItemPedido> = mutableSetOf()

    constructor(id: Int?, nome: String?, preco: Double?) {
        this.id = id
        this.nome = nome
        this.preco = preco
    }

    fun getPedidos(): List<Pedido> {
        val lista: MutableList<Pedido> = mutableListOf()
        for (x in itens) {
            x.pedido?.let { lista.add(it) }
        }
        return lista
        }
}

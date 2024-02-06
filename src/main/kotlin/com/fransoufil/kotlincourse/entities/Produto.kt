package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int?, var nome: String?, var preco: Double?
) : Serializable {

    companion object{
        private const val serialVersionUID = 1L
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "PRODUTO_CATEGORIA",
        joinColumns = [JoinColumn(name = "produto_id")],
        inverseJoinColumns = [JoinColumn(name = "categoria_id")]
    )
    var categorias: MutableList<Categoria> = mutableListOf()

}
package com.fransoufil.kotlincourse.entities.dto

import com.fransoufil.kotlincourse.entities.Produto
import java.io.Serializable

class ProdutoDTO() : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    var id: Int? = null
    var nome: String? = null
    var preco: Double? = null

    constructor(obj: Produto) : this() {
        id = obj.id
        nome = obj.nome
        preco = obj.preco
    }
}
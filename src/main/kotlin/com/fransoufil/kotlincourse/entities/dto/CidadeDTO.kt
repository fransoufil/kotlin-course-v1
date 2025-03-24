package com.fransoufil.kotlincourse.entities.dto

import com.fransoufil.kotlincourse.entities.Cidade
import java.io.Serializable


class CidadeDTO() : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    var id: Int? = null
    var nome: String? = null

    constructor(obj: Cidade) : this() {
        id = obj.id
        nome = obj.nome
    }
}
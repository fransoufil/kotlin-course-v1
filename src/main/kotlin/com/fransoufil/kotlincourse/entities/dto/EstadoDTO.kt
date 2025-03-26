package com.fransoufil.kotlincourse.entities.dto

import com.fransoufil.kotlincourse.entities.Estado
import java.io.Serializable

data class EstadoDTO(
    var id: Int? = null,
    var nome: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    constructor(obj: Estado) : this(
        id = obj.id,
        nome = obj.nome
    )
}
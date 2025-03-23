package com.fransoufil.kotlincourse.entities.dto

import com.fransoufil.kotlincourse.entities.Categoria
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length
import java.io.Serializable

class CategoriaDTO() : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    var id: Int? = null

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    var nome: String? = null

    constructor(obj: Categoria) : this() {
        id = obj.id
        nome = obj.nome
    }
}
package com.fransoufil.kotlincourse.entities.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import java.io.Serializable

data class EmailDTO(
    @field:NotEmpty(message = "Preenchimento obrigatório")
    @field:Email(message = "Email inválido")
    var email: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}
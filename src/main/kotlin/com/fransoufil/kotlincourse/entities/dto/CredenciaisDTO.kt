package com.fransoufil.kotlincourse.entities.dto
import java.io.Serializable

data class CredenciaisDTO(
    var email: String? = null,
    var senha: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}
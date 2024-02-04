package com.fransoufil.kotlincourse.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.io.Serializable

@Entity
class Categoria : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var nome: String? = null

    constructor(id: Int?, nome: String?) {
        this.id = id
        this.nome = nome
    }

}
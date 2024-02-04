package com.fransoufil.kotlincourse.entities

import jakarta.persistence.*
import java.io.Serializable

@Entity
class Cidade : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var nome: String? = null

    @ManyToOne
    @JoinColumn(name = "estado_id")
    var estado: Estado? = null

    constructor(id: Int?, nome: String?, estado: Estado?) {
        this.id = id
        this.nome = nome
        this.estado = estado
    }
}
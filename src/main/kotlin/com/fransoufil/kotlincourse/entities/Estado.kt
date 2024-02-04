package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
class Estado : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var nome: String? = null

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    var cidades: MutableList<Cidade> = mutableListOf()

    constructor(id: Int?, nome: String?) {
        this.id = id
        this.nome = nome
    }
}
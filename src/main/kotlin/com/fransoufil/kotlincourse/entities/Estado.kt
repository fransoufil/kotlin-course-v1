package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
class Estado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int?, var nome: String?
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    var cidades: MutableList<Cidade> = mutableListOf()

}
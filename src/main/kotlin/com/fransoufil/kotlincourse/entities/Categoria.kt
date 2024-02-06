package com.fransoufil.kotlincourse.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.io.Serializable

@Entity
class Categoria(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int?, var nome: String?
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }


    @ManyToMany(mappedBy = "categorias")
    var produtos: MutableList<Produto> = mutableListOf()

}
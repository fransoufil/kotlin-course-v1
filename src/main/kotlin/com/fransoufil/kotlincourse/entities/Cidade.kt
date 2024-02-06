package com.fransoufil.kotlincourse.entities

import jakarta.persistence.*
import java.io.Serializable

@Entity
class Cidade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int?, var nome: String?, @ManyToOne
    @JoinColumn(name = "estado_id") var estado: Estado?
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

}
package com.fransoufil.kotlincourse.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.io.Serializable

@Entity
class Endereco : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var logradouro: String? = null
    var numero: String? = null
    var complemento: String? = null
    var bairro: String? = null
    var cep: String? = null

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    var cidade: Cidade? = null

    constructor(
        id: Int?,
        logradouro: String?,
        numero: String?,
        complemento: String?,
        bairro: String?,
        cep: String?,
        cliente: Cliente?,
        cidade: Cidade?
    ) {
        this.id = id
        this.logradouro = logradouro
        this.numero = numero
        this.complemento = complemento
        this.bairro = bairro
        this.cep = cep
        this.cliente = cliente
        this.cidade = cidade
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        return id == other.id
    }

    override fun hashCode(): Int {
        return id ?: 0
    }

}
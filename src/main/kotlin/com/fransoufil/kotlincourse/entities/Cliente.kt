package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fransoufil.kotlincourse.entities.enums.TipoCliente
import jakarta.persistence.CascadeType
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.io.Serializable

@Entity
class Cliente : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    var nome: String? = null

    @Column(unique = true)
    var email: String? = null

    var cpfCnpj: String? = null

    var tipo: Int? = null

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    var enderecos: List<Endereco> = ArrayList()

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    var telefones: Set<String> = HashSet()

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    val pedidos: MutableList<Pedido> = mutableListOf()

    constructor(id: Int?, nome: String?, email: String?, cpfCnpj: String?, tipo: TipoCliente?) {
        this.id = id
        this.nome = nome
        this.email = email
        this.cpfCnpj = cpfCnpj
        if (tipo != null) {
            this.tipo = tipo.getCod()
        }
    }

    fun getTipo(): TipoCliente {
        return TipoCliente.toEnum(tipo)
    }

    fun setTipo(tipoCliente: TipoCliente) {
        this.tipo = tipoCliente.getCod()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        return id == other.id
    }

    override fun hashCode(): Int {
        return id ?: 0
    }

}
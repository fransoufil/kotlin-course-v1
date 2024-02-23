package com.fransoufil.kotlincourse.entities

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
class Pedido : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    var instante: Date? = null

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "pedido")
    var pagamento: Pagamento? = null

    @ManyToOne
    @JoinColumn(name="cliente_id")
    var cliente: Cliente? = null

    @ManyToOne
    @JoinColumn(name="endereco_de_entrega_id")
    var enderecoDeEntrega: Endereco? = null

    constructor(id: Int?, instante: Date?, cliente: Cliente?, enderecoDeEntrega: Endereco?) {
        this.id = id
        this.instante = instante
        this.cliente = cliente
        this.enderecoDeEntrega = enderecoDeEntrega
    }
}
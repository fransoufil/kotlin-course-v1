package com.fransoufil.kotlincourse.entities

import com.fransoufil.kotlincourse.entities.enums.EstadoPagamento
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Pagamento : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    @Id
    var id: Int? = null

    var estado: Int? = null

    @OneToOne
    @JoinColumn(name="pedido_id")
    @MapsId
    var pedido: Pedido? = null

    constructor(id: Int?, estado: EstadoPagamento, pedido: Pedido?) {
        this.id = id
        this.estado = estado.getCod()
        this.pedido = pedido
    }
}
package com.fransoufil.kotlincourse.entities

import com.fransoufil.kotlincourse.entities.enums.EstadoPagamento
import jakarta.persistence.Entity

@Entity
class PagamentoComCartao: Pagamento {
    companion object {
        private const val serialVersionUID = 1L
    }

    var numeroDeParcelas: Int? = null

    constructor(id: Int?, estadoPagamento: EstadoPagamento, pedido: Pedido?, numeroDeParcelas: Int?) : super(id, estadoPagamento, pedido){
        this.numeroDeParcelas = numeroDeParcelas
    }

}
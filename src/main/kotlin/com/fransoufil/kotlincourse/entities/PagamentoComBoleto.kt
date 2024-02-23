package com.fransoufil.kotlincourse.entities

import com.fransoufil.kotlincourse.entities.enums.EstadoPagamento
import jakarta.persistence.Entity
import java.util.Date

@Entity
class PagamentoComBoleto: Pagamento {

    companion object {
        private const val serialVersionUID = 1L
    }

    private var dataVencimento: Date? = null
    private var dataPagamento: Date? =  null

    constructor(id: Int?, estado: EstadoPagamento, pedido: Pedido?, dataVencimento: Date?, dataPagamento: Date?) : super(id, estado, pedido){
        this.estado = estado.getCod()
        this.dataVencimento = dataVencimento
        this.dataPagamento = dataPagamento
    }

}
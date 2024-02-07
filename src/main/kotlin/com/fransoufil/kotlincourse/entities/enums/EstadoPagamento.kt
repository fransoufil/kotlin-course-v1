package com.fransoufil.kotlincourse.entities.enums

import java.lang.IllegalArgumentException

enum class EstadoPagamento (private val cod: Int, private val descricao: String) {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    fun getCod(): Int{
        return cod
    }

    fun getDescricao(): String {
        return descricao
    }

    companion object {
        fun toEnum(cod: Int?): EstadoPagamento {
            if (cod == null) {
                return PENDENTE
            }

            for (x in values()){
                if (cod == x.getCod()){
                    return x
                }
            }

            throw IllegalArgumentException("Id para EstadoPagamento inválido: $cod")
        }
    }
}
package com.fransoufil.kotlincourse.entities.enums

import java.lang.IllegalArgumentException

enum class TipoCliente (private val cod: Int, private val descricao: String){
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    fun getCod(): Int{
        return cod
    }

    fun getDescricao(): String {
        return descricao
    }

    companion object {
        fun toEnum(cod: Int?): TipoCliente {
            if (cod == null) {
                return PESSOAFISICA
            }

            for (x in values()){
                if (cod == x.getCod()){
                    return x
                }
            }

            throw IllegalArgumentException("Id para TipoCliente inválido: $cod")
        }
    }
}
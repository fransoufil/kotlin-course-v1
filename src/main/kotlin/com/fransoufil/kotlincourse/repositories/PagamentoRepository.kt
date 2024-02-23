package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Pagamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PagamentoRepository: JpaRepository<Pagamento, Int> {
}
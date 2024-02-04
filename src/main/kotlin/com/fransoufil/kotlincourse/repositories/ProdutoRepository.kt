package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository: JpaRepository<Produto, Int> {
}
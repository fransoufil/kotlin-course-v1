package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Cidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository: JpaRepository<Cidade, Int> {
}
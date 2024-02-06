package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Int> {
}
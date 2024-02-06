package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Int> {
}
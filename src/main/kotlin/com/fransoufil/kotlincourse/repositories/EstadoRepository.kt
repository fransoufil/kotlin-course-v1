package com.fransoufil.kotlincourse.repositories

import com.fransoufil.kotlincourse.entities.Estado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstadoRepository: JpaRepository<Estado, Int> {
}
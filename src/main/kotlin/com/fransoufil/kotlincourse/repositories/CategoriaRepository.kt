package com.fransoufil.kotlincourse.repositories


import com.fransoufil.kotlincourse.entities.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<Categoria, Int> {
}
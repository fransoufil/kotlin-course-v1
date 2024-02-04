package com.fransoufil.kotlincourse

import com.fransoufil.kotlincourse.entities.Categoria
import com.fransoufil.kotlincourse.repositories.CategoriaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class KotlinCourseApplication: CommandLineRunner {

	@Autowired
	private lateinit var categoriaRepository: CategoriaRepository

	override fun run(vararg args: String) {
		val cat1 = Categoria(id = null, nome = "Informática")
		val cat2 = Categoria(id = null, nome = "Escritório")
		val cat3 = Categoria(id = null, nome = "Cama, Mesa e Banho")
		val cat4 = Categoria(id = null, nome = "Eletronicos")
		val cat5 = Categoria(id = null, nome = "Cuidado Pessoal")

		categoriaRepository.saveAll(listOf(cat1, cat2, cat3, cat4, cat5))

}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(KotlinCourseApplication::class.java, *args)
		}
	}
}

package com.fransoufil.kotlincourse

import com.fransoufil.kotlincourse.entities.Categoria
import com.fransoufil.kotlincourse.entities.Produto
import com.fransoufil.kotlincourse.repositories.CategoriaRepository
import com.fransoufil.kotlincourse.repositories.ProdutoRepository
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

	@Autowired lateinit var produtoRepository: ProdutoRepository

	override fun run(vararg args: String) {
		val cat1 = Categoria(id = null, nome = "Informática")
		val cat2 = Categoria(id = null, nome = "Escritório")
		val cat3 = Categoria(id = null, nome = "Cama, Mesa e Banho")
		val cat4 = Categoria(id = null, nome = "Eletronicos")
		val cat5 = Categoria(id = null, nome = "Cuidado Pessoal")

		val pro1 = Produto(null, "Computador", 2000.00)
		val pro2 = Produto(null, "Impressora", 800.00)
		val pro3 = Produto(null, "Mouse", 80.00)
		val pro4 = Produto(null, "Lencol de Casal", 200.00)
		val pro5 = Produto(null, "Mesa de Reunião", 1500.00)
		val pro6 = Produto(null, "Creme de Barbear", 40.00)
		val pro7 = Produto(null, "Caixa de Som", 1200.00)

		cat1.produtos.addAll(listOf(pro1, pro2,pro3))
		cat2.produtos.addAll(listOf(pro5))
		cat3.produtos.addAll(listOf(pro4))
		cat4.produtos.addAll(listOf(pro1, pro2, pro3, pro7))
		cat5.produtos.addAll(listOf(pro6))

		pro1.categorias.addAll(listOf(cat1, cat4))
		pro2.categorias.addAll(listOf(cat1, cat4))
		pro3.categorias.addAll(listOf(cat1, cat4))
		pro4.categorias.addAll(listOf(cat3))
		pro5.categorias.addAll(listOf(cat2))
		pro6.categorias.addAll(listOf(cat5))
		pro7.categorias.addAll(listOf(cat4))

		categoriaRepository.saveAll(listOf(cat1, cat2, cat3, cat4, cat5))
		produtoRepository.saveAll(listOf(pro1, pro2, pro3, pro4, pro5, pro6, pro7))

}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(KotlinCourseApplication::class.java, *args)
		}
	}
}

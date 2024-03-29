package com.fransoufil.kotlincourse

import com.fransoufil.kotlincourse.entities.*
import com.fransoufil.kotlincourse.entities.enums.EstadoPagamento
import com.fransoufil.kotlincourse.entities.enums.TipoCliente
import com.fransoufil.kotlincourse.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SpringBootApplication
@EnableJpaRepositories
class KotlinCourseApplication: CommandLineRunner {

	@Autowired private lateinit var categoriaRepository: CategoriaRepository

	@Autowired lateinit var produtoRepository: ProdutoRepository

	@Autowired lateinit var cidadeRepository: CidadeRepository

	@Autowired lateinit var estadoRepository: EstadoRepository

	@Autowired lateinit var clienteRepository: ClienteRepository

	@Autowired lateinit var enderecoRepository: EnderecoRepository

	@Autowired lateinit var pedidoRepository: PedidoRepository

	@Autowired lateinit var pagamentoRepository: PagamentoRepository

	@Autowired lateinit var itemPedidoRepository: ItemPedidoRepository

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

		val est1 = Estado(null, "Minas Gerais")
		val est2 = Estado(null, "São Paulo")

		val cid1 = Cidade(null, "Uberlândia", est1)
		val cid2 = Cidade(null, "São Paulo", est2)
		val cid3 = Cidade(null, "Campinas", est2)

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
		estadoRepository.saveAll(listOf(est1, est2))
		cidadeRepository.saveAll(listOf(cid1, cid2, cid3))

		val cli1 = Cliente(null, "Francisco Souza", "francisco@souza.com", "36378912377", TipoCliente.PESSOAFISICA)
		val cli2 = Cliente(null, "Ana Clara", "ana@clara.com", "61715708938", TipoCliente.PESSOAFISICA )
		val cli3 = Cliente(null, "FranzCorp", "franz@corp.com", "37724906000169", TipoCliente.PESSOAJURIDICA)

		cli1.telefones += "27363323"
		cli1.telefones += "93838393"
		cli2.telefones += "22222222"
		cli2.telefones += "922222222"
		cli3.telefones += "33333333"
		cli3.telefones += "933333333"

		val e1 = Endereco(null, "Rua Flores", "300", "Apt 303", "Jardim", "38220834", cli1, cid1)
		val e2 = Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2)
		val e3 = Endereco(null, "Avenida Ana", "77", "Sala 7", "Vila Sete", "77777777", cli2, cid1)
		val e4 = Endereco(null, "Rua Souza", "555", "Sala 55", "Jardim Cinco", "55555555", cli3, cid3)

		cli1.enderecos += e1
		cli1.enderecos += e2
		cli2.enderecos += e3
		cli3.enderecos += e4

		clienteRepository.saveAll(listOf(cli1, cli2, cli3))
		enderecoRepository.saveAll(listOf(e1, e2, e3, e4))

		val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")

		val ped1 = Pedido(null, sdf.parse("25/01/2024 10:43"), cli1, e1)
		val ped2 = Pedido(null, sdf.parse("03/02/2024 19:05"), cli1, e2)

		val pagto1 = PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 5)
		ped1.pagamento = pagto1

		val pagto2 = PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("05/02/2024 20:06"), null)
		ped2.pagamento = pagto2

		cli1.pedidos.addAll(listOf(ped1, ped2))

		pedidoRepository.saveAll(listOf(ped1, ped2))
		pagamentoRepository.saveAll(listOf(pagto1, pagto2))

		val ip1 = ItemPedido(ped1, pro1, 0.00, 1, 2000.00)
		val ip2 = ItemPedido(ped1, pro3, 0.00, 2, 80.00)
		val ip3 = ItemPedido(ped2, pro2, 100.00, 1, 800.00)

		ped1.itens.addAll(listOf( ip1, ip2))
		ped2.itens.addAll(listOf(ip3))

		pro1.itens.addAll(listOf(ip1))
		pro2.itens.addAll(listOf(ip3))
		pro3.itens.addAll(listOf(ip2))

		itemPedidoRepository.saveAll(listOf(ip1, ip2, ip3))

	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(KotlinCourseApplication::class.java, *args)
		}
	}
}

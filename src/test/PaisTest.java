package test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//import dao.PaisDao;
import model.Pais;
import service.PaisService;

import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	public Pais pais, copia;
	public ArrayList<Pais> paises = new ArrayList<Pais>();
	//public PaisDao dao = new PaisDao();
	public PaisService service = new PaisService();
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		//pais = new Pais(id, "Mexico", 56910000, 289125);
		//copia = new Pais(id, "Mexico", 56910000, 289125 );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		service.criar(pais);
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}
	
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);
		service.atualizar(pais);
		service.carregar(id);
		assertEquals("testa atualizacao", pais, copia);
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome("Mexico");
		copia.setPopulacao(56910000);
		//copia.setArea(289125.0);
		copia.toString();
		
		//service.excluir(pais);
		service.carregar(id);
		pais.toString();
		assertEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o pais 7 deve ter sido carregado no banco por fora
		//Pais fixture = new Pais(7, "Mexico", 999999, 120125.00);
		//Pais novo = new Pais(7, "Mexico", 999999, 120125.00);
		service.carregar(7);
		//assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void teste04MaiorNumeroHabitantes() {
		System.out.println("teste04MaiorNumeroHabitantes");
		//Pais paisTeste = service.carregarPaisMaiorNumeroHabitantes();
		
		copia.setNome("Bolivia");
		copia.setPopulacao(257400000);
		
		//assertEquals("Testa nome", paisTeste.getNome(), "Bolivia");
		//assertEquals("Testa humero habitantes", paisTeste.getPopulacao(), 257400000);
	}
	
	@Test
	public void Test05carregarPaisMenorArea() {
		System.out.println("Test05carregarPaisMenorArea");
		//Pais paisTeste = service.carregarPaisMaiorNumeroHabitantes();
		//service.carregarPaisMenorArea();
		//assertEquals("Testa area", paisTeste.getNome(), "Mexico");
	}
	
	@Test
	public void Test05TresPaises() {
		System.out.println("Test05TresPaises");
		//paises = service.carregarMultiplosPaises(3);
		
		assertEquals("quantidade paises", 3, paises);
	}
}